<script setup lang="ts">
import { ref, watch } from 'vue';
import { useGameStore } from '../composables/useGameStore';

const gameStore = useGameStore();
const moves = ref([])
const player1 = ref(null)
const player2 = ref(null)

watch(
  () => gameStore.getQueue.length,
  () => {
    moves.value = gameStore.queueMovement
    mainLoop();
  },
)
const drawPlayerInPosition = (move: number, player: number) => {
  const squareToMove = document.getElementById(`square${move}`);
  if (player === 1) {
    squareToMove.append(player1.value);
  } else {
    squareToMove.append(player2.value);
  }
  gameStore.addLog(player, move);

  wait(1000);

}

function wait(ms) {
  const esperarHasta = new Date().getTime() + ms;
  while (new Date().getTime() < esperarHasta) continue;
};

const mainLoop = () => {
  const timer = setInterval(function () {
    if(moves.value.length == 0) {
      clearInterval(timer);
      return
    }
    const { move, player } = moves.value.shift();
    console.log(move, player);
    
    drawPlayerInPosition(move, player);
  }, 1000);

}

</script>

<template>
  <section class="players">
  </section>
  <div class="board">
    <div id="square1">
      <div class="player1" ref="player1" v-show="gameStore.isFirstActive"></div>
    </div>
    <div id="square2"></div>
    <div id="square3"></div>
    <div id="square4">
      <div class="player2" ref="player2" v-show="gameStore.isSecondActive"></div>
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

<style scoped>
.board {
  width: 65%;
  height: 70%;
  border-radius: 5px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-template-rows: repeat(4, 1fr);
  grid-column-gap: 0px;
  grid-row-gap: 0px;
  box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 2px, rgba(0, 0, 0, 0.07) 0px 2px 4px, rgba(0, 0, 0, 0.07) 0px 4px 8px, rgba(0, 0, 0, 0.07) 0px 8px 16px, rgba(0, 0, 0, 0.07) 0px 16px 32px, rgba(0, 0, 0, 0.07) 0px 32px 64px;
}

.players {
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  width: 100%;
}

.player1 {
  width: 111px;
  height: 48px;
  background: transparent url('../assets/blue_static.png') 0 0 no-repeat;
  position: absolute;
  animation: idle-blue .9s steps(6) infinite;
  left: 0;
  z-index: 100000;
}

.player2 {
  width: 120px;
  height: 60px;
  background: transparent url('../assets/red_static.png') 0 0 no-repeat;
  animation: idle-white .9s steps(6) infinite;
  position: absolute;
}

.playerMoving1 {
  width: 111px;
  height: 48px;
  background: transparent url('../assets/white_run.png') 0 0 no-repeat;
  position: absolute;
  animation: run_blue 10s steps(8) infinite;
  left: 0;
  transition: .5s ease-in-out;
}

.playerMoving2 {
  width: 120px;
  height: 60px;
  background: transparent url('../assets/red_run.png') 0 0 no-repeat;
  position: absolute;
  animation: run_red 1s steps(8) infinite;
  transition: 4s ease-in-out;
}

@keyframes idle-blue {
  100% {
    background-position: 0 -290px;
  }
}

@keyframes idle-white {
  100% {
    background-position: 0 -384px;
  }
}

@keyframes run_blue {
  100% {
    background-position: 0 -384px;
  }
}

@keyframes run_red {
  100% {
    background-position: 0 -512px;
  }
}

div[id^='square'] {
  width: 100%;
  height: 100%;
  background-image: url('../assets/Brickwall4_Texture.png');
  background-size: cover;
  background-position: center;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
}

#square1,
#square3,
#square6,
#square8,
#square9,
#square11,
#square14,
#square16 {
  background-image: url('../assets/Brickwall5_Texture.png') !important;
  background-size: cover;
  background-position: center;
}

#square1 {
  grid-area: 1 / 1 / 2 / 2;
  border-top-left-radius: 5px;
}

#square2 {
  grid-area: 1 / 2 / 2 / 3;
}

#square3 {
  grid-area: 1 / 3 / 2 / 4;
}

#square4 {
  grid-area: 1 / 4 / 2 / 5;
  border-top-right-radius: 5px;
}

#square5 {
  grid-area: 2 / 1 / 3 / 2;
}

#square6 {
  grid-area: 2 / 2 / 3 / 3;
}

#square7 {
  grid-area: 2 / 3 / 3 / 4;
}

#square8 {
  grid-area: 2 / 4 / 3 / 5;
}

#square9 {
  grid-area: 3 / 1 / 4 / 2;
}

#square10 {
  grid-area: 3 / 2 / 4 / 3;
}

#square11 {
  grid-area: 3 / 3 / 4 / 4;
}

#square12 {
  grid-area: 3 / 4 / 4 / 5;
}

#square13 {
  grid-area: 4 / 1 / 5 / 2;
  border-bottom-left-radius: 5px;
}

#square14 {
  grid-area: 4 / 2 / 5 / 3;
}

#square15 {
  grid-area: 4 / 3 / 5 / 4;
}

#square16 {
  grid-area: 4 / 4 / 5 / 5;
  border-bottom-right-radius: 5px;
}
</style>

