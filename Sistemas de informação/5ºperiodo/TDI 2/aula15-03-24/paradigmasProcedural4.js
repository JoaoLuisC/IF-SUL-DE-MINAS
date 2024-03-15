//Tipicamente é um codigo procedural abaixo
const numeros = [1, 2, 3, 4, 5];
const quadrados = [];

for (let n of numeros) {
    quadrado = n * n;
    quadrados.push(quadrado);
}

console.log(numeros);
console.log(quadrados);

//Metodo mais funcional        
// function quadrado(valor){
//     return valor*valor;                      
// }                                            
//                                              
//ISSO É UM FANÇÃO LAMBDA                         
//OU SEJA SAO FUNÇÕES Q SIMPLIFICAM DMS  
//O MAP OPERA A FUNÇÃO LMABDA PARA TODOS OS ELEMENTOS DO VETOR ORIGINAL        
const quadrados2 = numeros.map((n) => n * n);
const quadrados3 = numeros.map(n => n * n);

//Exemplo com reduce
const quadrados4 = numeros.reduce;


console.log(quadrados2);
console.log(quadrados3);