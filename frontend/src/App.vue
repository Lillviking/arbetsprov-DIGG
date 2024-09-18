<script setup lang="ts">
import { RouterView } from 'vue-router'
</script>

<template>
    <header>
            <div class="sidenav">
                <RouterLink to="/" class="nav-text">Kundlista</RouterLink>
                <RouterLink to="/addCustomer" class="nav-text">Lägg till kund</RouterLink>
                <div class="empty-div"></div>
                <div class="empty-div2"></div>
                <div class="empty-div3"></div>
                <div class="empty-div4"></div>
                <div class="empty-div5"></div>
            </div>
    </header>
    <div class="content"><RouterView /></div>
    
</template>

<style scoped>

.sidenav {
    height: 100%;
    width: 20rem;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #695F59;
    overflow-x: hidden;
    padding-top: 3rem;
    display: flex;
    flex-direction: column;
}

.nav-text {
    color: white;
    font-weight: bold;
    margin-top: 2rem;
    padding-left: 3rem;
}

.nav-text:nth-of-type(2) {
    margin-bottom: 8rem; 
}

.content {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    width: 100vw;
}

.empty-div {
    height: 40px;
    width: 100%;
    background-color: #EBC0B8;
    flex-grow: 1;
}

.empty-div2 {
    height: 40px;
    width: 100%;
    background-color: #D6D9D3;
    flex-grow: 2;
}

.empty-div3 {
    height: 40px;
    width: 100%;
    background-color: #F0EFEE;
    flex-grow: 3;
}

.empty-div4 {
    height: 40px;
    width: 100%;
    background-color: #CD7A6E;
    flex-grow: 1;
}

.empty-div5 {
    height: 40px;
    width: 100%;
    background-color: #F7E4E1;
    flex-grow: 4;
}

a {
    text-decoration: none;
    font-size: 2rem;
}
</style>