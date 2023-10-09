import { defineStore } from "pinia";
import { Ref, computed, ref } from "vue";

const API = 'http://localhost:3000/game';

export const useGameStore = defineStore('game', () => {
  const queueMovement = ref([]);
  const numberOfPlayers: Ref<number> = ref<number>(0);

  const firstPlayerActive = ref(false);
  const secondPlayerActive = ref(false);

  const playerOneString = ref('');
  const playerTwoString = ref('')

  const gameLogs = ref([]);

  function setNumberOfPlayers(total: number) {
    if(total === 1) {
      firstPlayerActive.value = true;
    }

    if(total === 2) {
      firstPlayerActive.value = true;
      secondPlayerActive.value = true;
    }
    numberOfPlayers.value = total;
  }

  async function getRandomStrings() { 
    const response = await fetch(API + '/generate', {
      body: JSON.stringify({ numberOfPlayers: numberOfPlayers.value }),
      method: 'POST'
    });

    return response.json();
  }

  async function startGame(moveOne: string | null, moveTwo: string | null) {
    if(numberOfPlayers.value == 1) {
      const response = await fetch(API + '/start', {
        body: JSON.stringify({ numberOfPlayers: numberOfPlayers.value, pattern1: moveOne }),
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
      });
      const { movePlayerOne } = await response.json();
      playerOneString.value = movePlayerOne;
      createQueuePlayerOne(movePlayerOne);
    } else {
      console.log({ 
        numberOfPlayers: numberOfPlayers.value, 
        pattern1: moveOne,
        pattern2: moveTwo
      });
      
      const response = await fetch(API + '/start', {
        body: JSON.stringify({ 
          numberOfPlayers: numberOfPlayers.value, 
          pattern1: moveOne,
          pattern2: moveTwo
        }),
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
      });
      const { movePlayerOne, movePlayerTwo } = await response.json();
      playerOneString.value = movePlayerOne;
      playerTwoString.value = movePlayerTwo;
      createQueuePlayerOne(movePlayerOne, movePlayerTwo);
    }
  }

  async function getNewPath(traveledSoFar: string, squaresToAvoid: string, player: number, originalString: string) {
    const response = await fetch(API + '/rebuild', {
      body: JSON.stringify({ traveledSoFar, squaresToAvoid, player }),
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
    });
  }

  function createQueuePlayerOne(movementStringPlayerOne:string, movementStringPlayerTwo?: string) {
    if(numberOfPlayers.value == 1) {
      const moveArray = movementStringPlayerOne.split(' ');
      while(moveArray.length > 0) {
        const movement = parseInt(moveArray.shift());
        queueMovement.value.push({ player: 1, move: movement });
      }
    } else {
      const moveArrayPlayerOne = movementStringPlayerOne.split(' ');
      const moveArrayPlayerTwo = movementStringPlayerTwo.split(' ');
      const firstPlayerOne = (Math.random()>=0.5)? 1 : 0;
      while(moveArrayPlayerOne.length > 0) {
        const currentMovePlayerOne = parseInt(moveArrayPlayerOne.shift());
        const currentMovePlayerTwo = parseInt(moveArrayPlayerTwo.shift());

        if(firstPlayerOne) {
          queueMovement.value.push({ player: 1, move: currentMovePlayerOne });
          queueMovement.value.push({ player: 2, move: currentMovePlayerTwo });
        } else {
          queueMovement.value.push({ player: 2, move: currentMovePlayerTwo });
          queueMovement.value.push({ player: 1, move: currentMovePlayerOne });
        }
      }
    }
  }

  function addLog(player, move) {
    gameLogs.value.push({
      log: `jugador ${player} se mueve al cuadro ${move}`,
      player
    });
  }

  function addLogCollision(playerWhoCollide: number, collisionTo: number, collisionSquare: number) {
    gameLogs.value.push({
      log: `jugador ${playerWhoCollide} colisionara con ${collisionTo} en ${collisionSquare}`,
      player: playerWhoCollide
    })
  }

  const getNumberOfPlayers = computed(() => numberOfPlayers.value);
  const isFirstActive = computed(() => firstPlayerActive.value);
  const isSecondActive = computed(() => secondPlayerActive.value);
  const getQueue = computed(() => queueMovement.value);
  const getLogs = computed(() => gameLogs.value);

  return {
    setNumberOfPlayers,
    getNumberOfPlayers,
    numberOfPlayers,
    queueMovement,
    isFirstActive,
    isSecondActive,
    startGame,
    getQueue,
    addLog,
    addLogCollision,
    getLogs,
    getRandomStrings,
    getNewPath,
    createQueuePlayerOne,
    playerOneString,
    playerTwoString
  }
  
});
