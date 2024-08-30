let nativeStr = "Joao";
let nativeStrFunction = String("Luis");
let strAsObjetc = new String("Cardoso");

// console.log(typeof nativeStr); //String
// console.log(typeof nativeStrFunction); // String
// console.log(typeof strAsObjetc); //Object

let isString = strAsObjetc instanceof String; 

// console.log(typeof isString); //true


console.log(typeof nativeStr instanceof String); //false, para utilizar o instanceof o lado squerdo dele deve ser um Object
console.log(typeof nativeStrFunction instanceof String); //false


