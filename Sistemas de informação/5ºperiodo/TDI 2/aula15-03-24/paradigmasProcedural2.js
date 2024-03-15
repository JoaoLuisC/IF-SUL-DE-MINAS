//SINTAXE pré EcmaScripit6 - ES6

function Pessoa(nome, cpf) {
    //Atributos da função construtora
    this.nome = nome;
    this.cpf = cpf;

    this.saudar = function () {
        console.log(`Nome: ${this.nome}, CPF: ${this.cpf}`);
    }
    //OUTRA FORMA BAIANA 
    //this.saudar = minhaFuncao ();
}

///function minhaFuncao(){
//      console.log(`Nome: ${this.nome}, CPF: ${this.cpf}`);
//}

//MODO DE ADICIONAR UMA FUNÇÃO A CLASSE SEM TER ACESSO A ELA QUANDO ELA É UMA FUNÇÃO
// Pessoa.prototype.saudar = function(){
//     console.log(`Nome: ${this.nome}, CPF: ${this.cpf}`);
// }

console.log(`tipo do objeto Pessoa: ${typeof(Pessoa)}`);

const progamador = new Pessoa("Joao",123456);
console.log(progamador);
