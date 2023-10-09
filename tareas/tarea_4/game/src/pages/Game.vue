<script setup lang="ts">
import { ref, watch } from 'vue';
import Board from '../components/Board.vue';
import { useGameStore } from '../composables/useGameStore';
const gameStore = useGameStore();
const logsDiv = ref(null);
const inputPlayerOne = ref('');
const inputPlayerTwo = ref('');

watch(
  () => gameStore.getQueue.length,
  () => {
    logsDiv.value.scrollTo({
      top: logsDiv.value.scrollHeight,
      behavior: 'smooth',
    });
  },
);

const setRandomStrings = async () => {
  inputPlayerOne.value = '';
  inputPlayerTwo.value = '';
  if(gameStore.getNumberOfPlayers === 1) {
    const { string1 } = await gameStore.getRandomStrings();
    inputPlayerOne.value = string1;
  } else {
    const { string1, string2 } = await gameStore.getRandomStrings();
    inputPlayerOne.value = string1;
    inputPlayerTwo.value = string2;
  }
}
</script>

<template>
  <main class="start">
    <div class="game">
      <div class="movements">
        <p class="movement">{{ gameStore.playerOneString }}</p>
        <p class="movement">{{ gameStore.playerTwoString }}</p>
      </div>
      <Board />
    </div>
    <div class="results">
      <div class="results__start">
        <div class="results__inputs">
          <input 
            class="results__input" 
            v-if="gameStore.isFirstActive"
            v-model="inputPlayerOne"
          >
          <input 
            class="results__input" 
            v-if="gameStore.isSecondActive"
            v-model="inputPlayerTwo"
            >
        </div>
        <div class="results__buttons">
          <button class="results__button" @click="setRandomStrings">Autogenerar</button>
          <button class="results__button" @click="gameStore.startGame(inputPlayerOne, inputPlayerTwo)">Empezar</button>
        </div>
      </div>
      <div class="results__logs" ref="logsDiv">
        <p v-for="(moves, i) in gameStore.getLogs" :key="i" class="log" :class="moves.player == 1 ? 'log1' : 'log2'">
          {{ i + '. ' + moves.log }}
        </p>
      </div>
    </div>
  </main>
</template>

<style scoped>
.start {
  width: 100%;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: space-around;
}

.game {
  width: 60%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  flex-direction: column;
}

.movements {
  display: flex;
  width: 100%;
  justify-content: space-evenly;
}

.movement:nth-child(1) {
  color: #0099ff;
}

.movement:nth-child(2) {
  color: #e4790e;
}



.results {
  width: 40%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-around;
  flex-direction: column;
  background-image: url('../assets/Brickwall5_Texture.png');
  background-position: center;
}

.results__start {
  width: 95%;
  height: 30%;
  border-radius: 5px;
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: space-evenly;
}

.results__inputs {
  width: 90%;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
}

.results__inputs>input {
  border: none;
  outline: none;
  height: 25px;
  padding: 1px;
  background: none;
  border-bottom: 1px solid #f0f0f0;
}

.results__input:nth-child(1) {
  caret-color: #0099ff;
  color: #0099ff;
}

.results__input:nth-child(2) {
  caret-color: #e4790e;
  color: #e4790e;
}

.results__buttons {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
}

.results__buttons button {
  width: 120px;
  height: 35px;
  border-radius: 5px;
  border: none;
  outline: none;
  color: #fff;
  cursor: pointer;
}

.results__buttons button:nth-child(1) {
  background-color: #7A6889;
}

.results__buttons button:nth-child(2) {
  background-color: #6C7FA7;
}

.results__logs {
  width: 95%;
  height: 65%;
  border-radius: 5px;
  display: flex;
  align-items: flex-start;
  justify-content: flex-start;
  flex-direction: column;
  overflow-y: scroll;
}

.results__logs::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  background-color: #F5F5F5;
}

.results__logs::-webkit-scrollbar {
  width: 10px;
  background-color: #F5F5F5;
}

.results__logs::-webkit-scrollbar-thumb {
  background-color: #000000;
  border: 2px solid #555555;
}


.log {
  font-size: 13px;
  margin-top: 15px;
}

.log1 {
  color: #0099ff;
}

.log2 {
  color: #e4790e;
  align-self: flex-end;
  margin-right: 10px;
}

.list-move,
.list-enter-active,
.list-leave-active {
  transition: all .2s cubic-bezier(0.075, 0.82, 0.165, 1);
}

.list-enter-from,
.list-leave-to {
  opacity: 0;
  transform: translateX(-2rem);
}

.list-leave-active {
  position: absolute;
}
</style>
