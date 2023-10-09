<script setup lang="ts">
import { ref } from 'vue';
import { useGameStore } from '../composables/useGameStore';
import { useRouter } from 'vue-router';

const router = useRouter();
const gameStore = useGameStore(); 

const isPlayerOneSelected = ref(false);
const isPlayerTwoSelected = ref(false);
const selectPlayer = (player: string) => {
  if(player === 'one') {
    isPlayerOneSelected.value = !isPlayerOneSelected.value;
    return
  }

  isPlayerTwoSelected.value = !isPlayerTwoSelected.value;
}

const setNumberOfPlayers = () => {
  let numberOfPlayers = 0;
  console.log(isPlayerOneSelected.value, isPlayerTwoSelected.value);
  
  if(isPlayerOneSelected.value) numberOfPlayers++;
  if(isPlayerTwoSelected.value) numberOfPlayers++;

  if(numberOfPlayers == 0) {
    return;
  }

  gameStore.setNumberOfPlayers(numberOfPlayers);

  router.push('/game');
}

</script>

<template>
  <main class="menu">
    <div class="menu__title">
      <h2>Elige jugadores</h2>
    </div>
    <div class="menu__character">
      <div class="character" @click="selectPlayer('one')">
        <img src="../assets/blue.gif" :class="isPlayerOneSelected ? 'selected' : ''">
      </div>

      <div class="character" @click="selectPlayer('two')">
        <img src="../assets/red.gif" :class="isPlayerTwoSelected ? 'selected' : ''">
      </div>

    </div>

    <button class="menu__start" @click="setNumberOfPlayers">Jugar</button>
  </main>
</template>


<style scoped>
  .menu {
    width: 100%;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    flex-direction: column;
    background-image: url('../assets/Brickwall5_Texture.png');
    background-position: center;
  }

  .character {
    cursor: pointer;
  }

  .selected {
    border: 1px solid #fff;
  }

  .character img {
    width: 100%;
    height: 100%;
    transition: .3s ease-in;
    border-radius: 3px;
  }

  .menu__character {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    width: 250px;
    margin-top: 20px;
  }


  .menu__title h2 {
    color: #ffff;
  }

  .menu__start {
    width: 120px;
    height: 35px;
    border-radius: 5px;
    border: none;
    outline: none;
    margin-top: 20px;
    cursor: pointer;
    background-color: #6C7FA7;
    color: #fff;
  }

</style>
