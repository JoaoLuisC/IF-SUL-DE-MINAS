// Função para converter Decimal para Binário
function decimalParaBinario(decimal) {
    let binario = "";
    while (decimal > 0) {
        binario = (decimal % 2) + binario;
        decimal = Math.floor(decimal / 2);
    }
    return binario || "0";  // Caso seja 0
}

// Função para converter Decimal para Hexadecimal
function decimalParaHexadecimal(decimal) {
    const hexDigitos = "0123456789ABCDEF";
    let hexadecimal = "";
    while (decimal > 0) {
        let resto = decimal % 16;
        hexadecimal = hexDigitos[resto] + hexadecimal;
        decimal = Math.floor(decimal / 16);
    }
    return hexadecimal || "0";  // Caso seja 0
}

// Função para converter Decimal para Octal
function decimalParaOctal(decimal) {
    let octal = "";
    while (decimal > 0) {
        octal = (decimal % 8) + octal;
        decimal = Math.floor(decimal / 8);
    }
    return octal || "0";  // Caso seja 0
}

// Função para converter Binário para Decimal
function binarioParaDecimal(binario) {
    let decimal = 0;
    for (let i = 0; i < binario.length; i++) {
        decimal = decimal * 2 + (binario[i] === "1" ? 1 : 0);
    }
    return decimal;
}

// Função para converter Hexadecimal para Decimal
function hexadecimalParaDecimal(hex) {
    const hexDigitos = "0123456789ABCDEF";
    let decimal = 0;
    hex = hex.toUpperCase();
    for (let i = 0; i < hex.length; i++) {
        decimal = decimal * 16 + hexDigitos.indexOf(hex[i]);
    }
    return decimal;
}

// Função para converter Octal para Decimal
function octalParaDecimal(octal) {
    let decimal = 0;
    for (let i = 0; i < octal.length; i++) {
        decimal = decimal * 8 + (octal[i] - '0');
    }
    return decimal;
}

// Função para converter Binário para Hexadecimal
function binarioParaHexadecimal(binario) {
    let decimal = binarioParaDecimal(binario);
    return decimalParaHexadecimal(decimal);
}

// Função para converter Binário para Octal
function binarioParaOctal(binario) {
    let decimal = binarioParaDecimal(binario);
    return decimalParaOctal(decimal);
}

// Função para converter Hexadecimal para Binário
function hexadecimalParaBinario(hex) {
    let decimal = hexadecimalParaDecimal(hex);
    return decimalParaBinario(decimal);
}

// Função para converter Hexadecimal para Octal
function hexadecimalParaOctal(hex) {
    let decimal = hexadecimalParaDecimal(hex);
    return decimalParaOctal(decimal);
}

// Função para converter Octal para Binário
function octalParaBinario(octal) {
    let decimal = octalParaDecimal(octal);
    return decimalParaBinario(decimal);
}

// Função para converter Octal para Hexadecimal
function octalParaHexadecimal(octal) {
    let decimal = octalParaDecimal(octal);
    return decimalParaHexadecimal(decimal);
}

// Função para exibir o resultado no Modal (ajustada)
function mostrarResultado(mensagem) {
    document.getElementById('resultadoTexto').innerHTML = mensagem;
    let resultadoModal = new bootstrap.Modal(document.getElementById('resultadoModal'));
    resultadoModal.show();
}


// Função para converter Decimal para Binário, Hexadecimal e Octal
function converterDecimal() {
    let decimal = parseInt(document.getElementById('decimalInput').value);
    if (!isNaN(decimal)) {
        let binario = decimalParaBinario(decimal);
        let hexadecimal = decimalParaHexadecimal(decimal);
        let octal = decimalParaOctal(decimal);

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
    if (/^[01]+$/.test(binario)) {
        let decimal = binarioParaDecimal(binario);
        let hexadecimal = decimalParaHexadecimal(decimal);
        let octal = decimalParaOctal(decimal);

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
    if (/^[0-9A-Fa-f]+$/.test(hex)) {
        let decimal = hexadecimalParaDecimal(hex);
        let binario = decimalParaBinario(decimal);
        let octal = decimalParaOctal(decimal);

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
    if (/^[0-7]+$/.test(octal)) {
        let decimal = octalParaDecimal(octal);
        let binario = decimalParaBinario(decimal);
        let hexadecimal = decimalParaHexadecimal(decimal);

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
