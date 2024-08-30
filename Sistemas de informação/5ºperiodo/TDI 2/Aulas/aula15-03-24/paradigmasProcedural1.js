const soma = function (v1, v2) {
    return v1 + v2;
}

class Pessoa {

    //Atributos
    constructor(nome, cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //Metodos
    saudar() {
        console.log(`Nome: ${this.nome}, CPF: ${this.cpf}`);
    }

}

const emerson = new Pessoa("Emerson",123);
const jaulas = new Pessoa("Jaulas",333);
console.log(emerson);
console.log(`teste ${emerson}`);
console.log(`O cpd de jaulas é: ${jaulas.cpf}`);
console.log(`tipo do objeto Pessoa: ${typeof(Pessoa)}`);





//String

const nome = "Joao"
const meio = "Luis"
//template Strings ``, ALEM DE PODER COLOCAR QQL TEXTO DENTRO DA CRASE 
//É POSSIVL IMPUTAR VALORES DE VARIAL DENTRO DELA COM A SINTAXE `ASJHDJAH ${variavel}`
const familia = `Cardoso`
const completo = `${nome} ${meio} ${familia}`

console.log(completo);
