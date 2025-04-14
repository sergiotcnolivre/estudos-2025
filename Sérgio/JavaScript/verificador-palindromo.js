class Pilha {
    constructor() {
        this.elementos = [];
        this.topo = -1;
    }

    isEmpty() {
        return this.topo === -1;
    }

    push(e) {
        this.elementos.push(e);
        this.topo++;
    }

    pop() {
        if (!this.isEmpty()) {
            this.topo--;
            return this.elementos.pop();
        }
        return null;
    }

    peek() {
        if (!this.isEmpty()) {
            return this.elementos[this.topo];
        }
        return null;
    }

    print() {
        return this.elementos.join('');
    }
}

// function isPalindrome(word) {
//     let pilha = new Pilha();

//     // Coloca todas as letras da palavra na pilha
//     for (let i = 0; i < word.length; i++) {
//         pilha.push(word[i]);
//     }

//     // Monta a palavra invertida ao desempilhar
//     let invertida = '';
//     while (!pilha.isEmpty()) {
//         invertida += pilha.pop();
//     }

//     console.log(`Palavra original: ${word}`);
//     console.log(`Palavra invertida: ${invertida}`);

//     if (word === invertida) {
//         console.log("É um palíndromo ✅");
//         return true;
//     } else {
//         console.log("Não é um palíndromo ❌");
//         return false;
//     }
// }

// isPalindrome("ana");     // ✅
// isPalindrome("ovo");     // ✅
// isPalindrome("radar");   // ✅
// isPalindrome("casa");    // ❌


function stringReverse(string) {

    let pilha = new Pilha()
    let reversedString =  ""

    for(i = 0; i < string.isEmpty; i++) {
        pilha.push(string[i])
    }
    while (!pilha.isEmpty()) {
        reversedString += pilha.pop();
    }

    console.log('Original:', string);
    console.log('Reversed:', reversedString);
    return reversedString
}

stringReverse('abc')