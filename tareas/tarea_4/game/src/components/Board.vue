<script setup lang="ts">
import { ref, watch } from 'vue';
import { useGameStore } from '../composables/useGameStore';
import { useRouter } from 'vue-router';
const router = useRouter();

const gameStore = useGameStore();
const moves = ref([]);
const player1 = ref(null);
const player2 = ref(null);

const pathTraveledPlayer1 = ref('')
const pathTraveledPlayer2 = ref('')


const currentPlayer1Move = ref(null);
const currentPlayer2Move = ref(null);

watch(
  () => gameStore.getQueue.length,
  () => {
    moves.value = gameStore.queueMovement;
    mainLoop();
  }
)

if(gameStore.getNumberOfPlayers == 0) {
  router.push('/');
}

const drawPlayerInPosition = (move: number, player: number) => {
  const squareToMove = document.getElementById(`square${move}`);
  if (player === 1) {
    squareToMove.append(player1.value);
    currentPlayer1Move.value = move;
    pathTraveledPlayer1.value += move;
  } else {
    squareToMove.append(player2.value);
    currentPlayer2Move.value = move;
    pathTraveledPlayer2.value += move;
  }
  gameStore.addLog(player, move);

  wait(750);

}

const checkIfCollision = (move: number, player: number) => {
  if(gameStore.getNumberOfPlayers == 1) return;
  if(player === 1) {
    const fullString = gameStore.playerOneString.slice()
    
    if(currentPlayer2Move.value === move) {
      console.log(`${fullString.substring(fullString.indexOf(move.toString()))}`);
      gameStore.addLogCollision(1, 2, move)
    }
    
    
  } else {
    const fullString = gameStore.playerOneString.slice()
    if(currentPlayer1Move.value === move) {
      console.log(`${fullString.substring(fullString.indexOf(move.toString()))}`);
      gameStore.addLogCollision(2, 1, move)
    }
  }
}

function wait(ms) {
  const esperarHasta = new Date().getTime() + ms;
  while (new Date().getTime() < esperarHasta) continue;
}

const mainLoop = () => {
  const timer = setInterval(function () {
    if(moves.value.length == 0) {
      clearInterval(timer);
      return
    }
    const { move, player } = moves.value.shift();
    checkIfCollision(move, player);
    drawPlayerInPosition(move, player);
  }, 900);

}

</script>

<template>
  <section class="players">
    <div class="player1" ref="player1" v-show="gameStore.isFirstActive"></div>
    <div class="player2" ref="player2" v-show="gameStore.isSecondActive"></div>

  </section>
  <div class="board">
    <div id="square1">
    </div>
    <div id="square2"></div>
    <div id="square3"></div>
    <div id="square4">
    </div>
    <div id="square5"></div>
    <div id="square6"></div>
    <div id="square7"></div>
    <div id="square8"></div>
    <div id="square9"></div>
    <div id="square10"></div>
    <div id="square11"></div>
    <div id="square12"></div>
    <div id="square13"></div>
    <div id="square14"></div>
    <div id="square15"></div>
    <div id="square16"></div>
  </div>
</template>
