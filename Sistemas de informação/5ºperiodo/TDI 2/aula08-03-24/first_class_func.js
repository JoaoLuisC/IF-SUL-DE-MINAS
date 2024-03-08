function somaA(op1, op2) {
    return op1 + op2;
};

const soma = function (op1, op2) {
    return op1 + op2;
};

console.log(somaA(1, 2));
console.log(soma(5, 5));
console.log(soma("5", 5));

const somaB = function (op1, op2) {
    return op1 + op2;
};

console.log(somaB(1, 2));
console.log("Funcao passando paramentros de funcoes");

function hof(operation, writer, op1 ,op2) {
    console.log("Resultado: ")
    writer(operation(op1,op2));
};

hof(soma,console.log,1,2);