// Função para converter Decimal para Binário, Hexadecimal e Octal
function converterDecimal() {
    let decimal = document.getElementById('decimalInput').value;
    if (decimal !== "") {
        let binario = Number(decimal).toString(2);
        let hexadecimal = Number(decimal).toString(16).toUpperCase();
        let octal = Number(decimal).toString(8);

        mostrarResultado(`
            <h5>Decimal para Outras Bases:</h5>
            <p><strong>Binário:</strong> ${binario}</p>
            <p><strong>Hexadecimal:</strong> ${hexadecimal}</p>
            <p><strong>Octal:</strong> ${octal}</p>
        `);
    } else {
        alert('Por favor, insira um número decimal válido.');
    }
}

// Função para converter Binário para Decimal, Hexadecimal e Octal
function converterBinario() {
    let binario = document.getElementById('binaryInput').value;
    if (binario !== "") {
        let decimal = parseInt(binario, 2);
        let hexadecimal = decimal.toString(16).toUpperCase();
        let octal = decimal.toString(8);

        mostrarResultado(`
            <h5>Binário para Outras Bases:</h5>
            <p><strong>Decimal:</strong> ${decimal}</p>
            <p><strong>Hexadecimal:</strong> ${hexadecimal}</p>
            <p><strong>Octal:</strong> ${octal}</p>
        `);
    } else {
        alert('Por favor, insira um número binário válido.');
    }
}

// Função para converter Hexadecimal para Decimal, Binário e Octal
function converterHexadecimal() {
    let hex = document.getElementById('hexInput').value;
    if (hex !== "") {
        let decimal = parseInt(hex, 16);
        let binario = decimal.toString(2);
        let octal = decimal.toString(8);

        mostrarResultado(`
            <h5>Hexadecimal para Outras Bases:</h5>
            <p><strong>Decimal:</strong> ${decimal}</p>
            <p><strong>Binário:</strong> ${binario}</p>
            <p><strong>Octal:</strong> ${octal}</p>
        `);
    } else {
        alert('Por favor, insira um número hexadecimal válido.');
    }
}

// Função para converter Octal para Decimal, Binário e Hexadecimal
function converterOctal() {
    let octal = document.getElementById('octalInput').value;
    if (octal !== "") {
        let decimal = parseInt(octal, 8);
        let binario = decimal.toString(2);
        let hexadecimal = decimal.toString(16).toUpperCase();

        mostrarResultado(`
            <h5>Octal para Outras Bases:</h5>
            <p><strong>Decimal:</strong> ${decimal}</p>
            <p><strong>Binário:</strong> ${binario}</p>
            <p><strong>Hexadecimal:</strong> ${hexadecimal}</p>
        `);
    } else {
        alert('Por favor, insira um número octal válido.');
    }
}

// Função para exibir o resultado no Modal
function mostrarResultado(mensagem) {
    document.getElementById('resultadoTexto').innerHTML = mensagem;
    let resultadoModal = new bootstrap.Modal(document.getElementById('resultadoModal'));
    resultadoModal.show();
}
