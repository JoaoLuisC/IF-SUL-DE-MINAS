//Outra forma de cirar objeto

const Pessoa = {
    nome: "Bill",
    cpf: "123",
    nascimento: "12/03/2002",
    //saudar: function(){
    //    console.log(`Nome: ${this.nome}, CPF: ${this.cpf}`);
    //},
}
//Usar quando n tiver acesso a classe como uma bibliotexa
// e vc quiser fazer uma nova função nova naquela classe
Object.getPrototypeOf(Pessoa).saudar = function(){
        console.log(`Nome: ${this.nome}, CPF: ${this.cpf}`);
}
//usar o prototype para funções  e o __proto__ n  é recomendado usar pq é como se acessa um lugar privado 
console.log(Pessoa.__proto__);
console.log(Pessoa.prototype);


// console.log(Pessoa);
// console.log(Pessoa.saudar());
// console.log(typeof(Pessoa));