const form = document.getElementById('form');
const descInput = document.getElementById('descricao');
const valueInput = document.querySelector('#montante');
const balance = document.getElementById('balanco');
const revenue = document.querySelector('#din-positivo');
const expenses = document.querySelector('#din-negativo');
const transactionsList = document.getElementById('transacoes');

let transactionId = 0;
let transactionRecord = [];

try {
    transactionRecord = JSON.parse(localStorage.getItem('transactions'));
} catch(error) {
    transactionRecord = null;
}

if(transactionRecord) {
    transactionRecord.forEach(transaction => {
        sumToBalance(transaction);
        sumRevenueExpenses(transaction);
        addTransactionToList(transaction);
    });
} else {
    transactionId = 0;
    transactionRecord = [];
}

document.querySelector('.btn-receita').addEventListener('click', () => {
    handleTransactionEntry('receita');
});

document.querySelector('.btn-despesa').addEventListener('click', () => {
    handleTransactionEntry('despesa');
});

function handleTransactionEntry(type) {
    event.preventDefault();

    const descTransaction = descInput.value.trim();
    const valueTransaction = parseFloat(valueInput.value.trim());

    if(descTransaction == '') {
        alert("Informe a descrição da transação!");
        descInput.focus();
        return;
    }

    if(valueTransaction == '') {
        alert("Informe o valor da transação!");
        valueInput.focus();
        return;
    }

    const transaction = {
        id: transactionId++,
        desc: descTransaction,
        value: type === 'receita' ? Math.abs(valueTransaction) : -Math.abs(valueTransaction),
    }

    sumToBalance(transaction);
    sumRevenueExpenses(transaction);
    addTransactionToList(transaction);

    transactionRecord.push(transaction);
    localStorage.setItem('transactions', JSON.stringify(transactionRecord));

    descInput.value = '';
    valueInput.value = '';
};

function sumToBalance(transaction) {
    let balanceValue = balance.innerHTML.trim();
    balanceValue = balanceValue.replace('R$', '');
    balanceValue = parseFloat(balanceValue); 
    balanceValue += transaction.value;

    balance.innerHTML = `R$${balanceValue.toFixed(2)}`;
}

function sumRevenueExpenses(transaction) {
    const element = transaction.value > 0 ? revenue : expenses;
    const sub = transaction.value > 0 ? '+ R$' : '- R$';
    
    let value = element.innerHTML.replace(sub, '');
    value = parseFloat(value);
    value += Math.abs(transaction.value);

    element.innerHTML = `${sub}${value.toFixed(2)}`;
}

function addTransactionToList(transaction) {
    const cssClass = transaction.value > 0 ? 'positivo' : 'negativo';
    const currency = transaction.value > 0 ? 'R$' : '-R$';

    const liElement = document.createElement('li');
    liElement.classList.add(cssClass);
    liElement.innerHTML = `
        ${transaction.desc} <span>${currency}${Math.abs(transaction.value)}</span>
        <button class="delete-btn" onclick="deleteTransaction(${transaction.id})">X</button>
    `;

    transactionsList.appendChild(liElement);
}

function calculateAndUpdateBalance() {
    balance.innerHTML = 'R$0.00';
    revenue.innerHTML = '+ R$0.00';
    expenses.innerHTML = '- R$0.00';

    transactionRecord.forEach(transaction => {
        sumToBalance(transaction);
        sumRevenueExpenses(transaction);
    });
}

function deleteTransaction(id) {
    const transactionIndex = transactionRecord.findIndex(transaction => transaction.id === id);

    if (transactionIndex !== -1) {
        transactionRecord.splice(transactionIndex, 1);
        localStorage.setItem('transactions', JSON.stringify(transactionRecord));

        transactionsList.removeChild(transactionsList.childNodes[transactionIndex]);
        
        calculateAndUpdateBalance();
    }

    location.reload();
}