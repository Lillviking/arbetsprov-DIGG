<template>
    <div class="customers-container">
        <h2 class="title">Kunder</h2>
        <ul class="customers-list">
            <li v-for="customer in customers" :key="customer.email" class="customer-item">
                <span class="name">{{ customer.name }}</span>
                <span class="address">{{ customer.address }}</span>
                <span class="email">{{ customer.email }}</span>
                <span class="telephone">{{ customer.telephone }}</span>
            </li>
        </ul>

        <div class="pagination">
            <button @click="previousPage" :disabled="page === 0">Föregående</button>
            <span>Sida {{ page + 1 }}</span>
            <button @click="nextPage" :disabled="customers.length < size">Nästa</button>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            customers: [],
            page: 0,     // Vilken sida vi är på
            size: 10     // Hur många kunder per sida
        }
    },

    created() {
        this.fetchCustomers();
    },

    methods: {
        async fetchCustomers() {
            const response = await fetch(`http://localhost:8080/digg/user?page=${this.page}&size=${this.size}`);
            this.customers = await response.json();

            console.log(this.customers.length);
        },

        nextPage() {
            if(this.customers.length === this.size) {
                this.page++;
                this.fetchCustomers();
            }
        },

        previousPage() {
            if (this.page > 0) {
                this.page--;
                this.fetchCustomers();
            }
        }
    }
}
</script>

<style>
.customers-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 1rem 2rem;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    min-width: 700px;
}

.title {
    font-size: 2rem;
    text-align: center;
    margin-bottom: 1.5rem;
}

.customers-list {
    list-style-type: none;
    padding: 0;
}

.customer-item {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    gap: 2rem;
    background-color: #ffffff;
    padding: 1rem;
    margin-bottom: 0.75rem;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    transition: background-color 0.3s ease;
}

.name {
    font-weight: bold;
    text-align: left;
}

.address {
    text-align: left;
}

.email {
    text-align: left;
}

.telephone {
    text-align: right;
}

.pagination {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 1rem;
    margin-top: 1rem;
}

button {
    padding: 0.75rem;
    background-color: transparent;
    border-color: #5a6751;
    border: 2px solid;
    color: #5a6751;
    border-radius: 5px;
    cursor: pointer;
}

button:disabled {
    background-color: #ccc;
}

button:hover:enabled {
    background-color: #D6D9D3;
}
</style>
