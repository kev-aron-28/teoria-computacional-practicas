import { defineStore } from "pinia";
import { Ref, computed, ref } from "vue";

const API = 'http://localhost:3000/game';

export const useGameStore = defineStore('game', () => {
  const queueMovement = ref([]);
  const numberOfPlayers: Ref<number> = ref<number>(0);

  const firstPlayerActive = ref(false);
  const secondPlayerActive = ref(false);

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
      createQueuePlayerOne(movePlayerOne);
    } else {
      const response = await fetch(API + '/start', {
        body: JSON.stringify({ 
          numberOfPlayers: numberOfPlayers.value, 
          pattern1: moveOne,
          pattern2:  moveTwo
        }),
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
      });
      const { movePlayerOne, movePlayerTwo } = await response.json();
      createQueuePlayerOne(movePlayerOne, movePlayerTwo);
    }
  }

  function createQueuePlayerOne(movementStringPlayerOne:string, movementStringPlayerTwo?: string) {
    if(numberOfPlayers.value == 1) {
      
    }
  }


  function addLog(player, move) {
    gameLogs.value.push({
      log: `jugador ${player} se mueve al cuadro ${move}`,
      player
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
    getLogs,
    getRandomStrings,
  }
  
});
