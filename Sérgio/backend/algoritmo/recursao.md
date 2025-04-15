# 📘 Entendendo Algoritmos – Capítulo: Recursão

## 🔁 O que é Recursão?

**Recursão** é quando uma função chama a **si mesma** para resolver subproblemas menores de um problema maior.  
É uma forma elegante e muitas vezes mais simples de resolver problemas que possuem uma estrutura repetitiva ou divisível.

---

## 🧠 Conceito-chave

Todo problema recursivo deve ter:

1. **Caso base**: condição que encerra a recursão.
2. **Chamada recursiva**: a função se chama com uma entrada reduzida.

---

## 📦 Exemplo simples: Contagem regressiva

```java
public class RecursaoSimples {

    public static void contagemRegressiva(int n) {
        if (n == 0) {
            System.out.println("Fim!");
        } else {
            System.out.println(n);
            contagemRegressiva(n - 1); // chamada recursiva
        }
    }

    public static void main(String[] args) {
        contagemRegressiva(5);
    }
}
```

## 🧠 Benefícios da Recursão

- Reduz código complexo de repetição.

- Torna soluções mais naturais para problemas como:

  - Listas

  - Árvores

  - Divisão de problemas (ex: busca binária, quicksort)

---
## ⚠️ Cuidados

- Recursão pode causar estouro de pilha se não tiver um caso base claro.

- Em alguns casos, loops podem ser mais eficientes em termos de desempenho/memória.

