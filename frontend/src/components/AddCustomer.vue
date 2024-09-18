<template>
    <div class="add-customer-container">
        <h1>Lägg till kund</h1>
        <form @submit.prevent="submitAddcustomer" class="add-customer-form">

            <!-- Namn -->
            <div class="form-group">
                <label for="name">Namn:</label>
                <input v-model="name" id="name" class="form-input" required>
            </div>

            <!-- Address -->
            <div class="form-group">
                <label for="address">Adress:</label>
                <input v-model="address" id="address" class="form-input" required>
            </div>

            <!-- Email -->
            <div class="form-group">
                <label for="email">Email:</label>
                <input v-model="email" id="email" class="form-input" required type="email">
            </div>

            <!-- Telefonnummer -->
            <div class="form-group">
                <label for="telephone">Telefonnummer:</label>
                <input v-model="telephone" id="telephone" class="form-input" required>
            </div>

            <button type="submit" class="submit-button">Lägg till kund</button>
        </form>

        <div v-if="addcustomerResponse" :class="['response-message', { error: addcustomerResponse.error }]">
            <p>{{ addcustomerResponse.message }}</p>
            <div v-if="!addcustomerResponse.error">
                <strong>Du har lagt till kund:</strong><br>
                Namn: {{ customerData?.name || '' }}<br>
                Adress: {{ customerData?.address || '' }}<br>
                Mail: {{ customerData?.email || '' }}<br>
                Telefonnummer: {{ customerData?.telephone || '' }}<br>
            </div>

        </div>
    </div>


</template>

<script>

export default {
    data() {
        return {
            name: '',
            address: '',
            email: '',
            telephone: '',
            addcustomerResponse: '',
            customerData: null,
        }
    },

    methods: {
        async submitAddcustomer() {

            const customerData = {
                name: this.name,
                address: this.address,
                email: this.email,
                telephone: this.telephone,
            };

            try {
                const response = await fetch('http://localhost:8080/digg/user', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(customerData)
                });

                if (response.ok) {
                    this.customerData = { ...customerData };
                    this.addcustomerResponse = { message: 'En ny kund har lagts till', error: false };
                    this.name = '';
                    this.address = '';
                    this.email = '';
                    this.telephone = '';
                }

            } catch (error) {
                this.addcustomerResponse = { message: 'Ett fel uppstod, försök igen.', error: true };
            }
        }
    }
}

</script>

<style scoped>
.add-customer-container {
    max-width: 800px;
    margin: auto auto;
    padding: 1rem 2rem;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    min-width: 700px;
}

.add-customer-form {
    display: flex;
    flex-direction: column;
    gap: 1rem;
}

.form-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 1rem;
}

.form-group label {
    font-weight: bold;
    margin-bottom: 0.5rem;
    color: #252525;
    text-align: left;
}

.form-input {
    padding: 0.5rem;
    font-size: 1.6rem;
    border: 1px solid #bdc3c7;
    border-radius: 5px;
    background-color: #fff;
    transition: border-color 0.2s ease;
}

.form-input:focus {
    border-color: #3498db;
    outline: none;
}

.submit-button {
    padding: 0.75rem;
    background-color: transparent;
    border-color: #5a6751;
    border: 2px solid;
    color: #5a6751;
    border-radius: 5px;
    cursor: pointer;
    margin-bottom: 1rem;
}

.submit-button:hover {
    background-color: #D6D9D3;
}

.response-message {
    font-size: 1.2rem;
    text-align: left;
    color: #2ecc71;
    border: 2px solid #2ecc71;
    border-radius: 8px;
    margin-top: 1rem;
    margin-bottom: 1rem;
    padding: 1rem;
    transition: background-color 0.3s ease;
}

.response-message.error {
    background-color: #fce4e4;
    color: #e74c3c;
    border: 2px solid #e74c3c;
}

</style>