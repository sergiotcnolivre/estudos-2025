# 📘 Entendendo Algoritmos – Ordenação por Seleção

## 🔢 O que é Ordenação por Seleção?

A **ordenação por seleção** (selection sort) é um algoritmo de ordenação simples, que funciona repetidamente encontrando o **menor elemento** da lista e movendo-o para o início.

---

## ⚙️ Como funciona?

1. Percorre a lista inteira para encontrar o **menor elemento**.
2. Troca esse elemento com o primeiro da lista.
3. Repete o processo para o restante da lista (ignorando o primeiro elemento já ordenado).
4. Continua até que toda a lista esteja ordenada.

---

## 🧠 Complexidade

- **Tempo de execução**: `O(n²)`
- **Vantagens**: Simples de entender e implementar.
- **Desvantagens**: Ineficiente para listas grandes.

---

## 🔍 Exemplo passo a passo

Suponha a lista: `[5, 3, 6, 2, 10]`

1. Encontra o menor número: `2`, troca com o primeiro → `[2, 3, 6, 5, 10]`
2. Encontra o menor no restante: `3`, já está no lugar → `[2, 3, 6, 5, 10]`
3. Encontra `5`, troca com `6` → `[2, 3, 5, 6, 10]`
4. Lista ordenada!

---

## 💻 Exemplo em Java

```java
public class SelectionSort {

    // Método para ordenar usando seleção
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Encontra o índice do menor elemento
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Troca o atual com o menor encontrado
            int temp = array[i];
            array[i] = array[indiceMenor];
            array[indiceMenor] = temp;
        }
    }

    // Método principal para testar
    public static void main(String[] args) {
        int[] numeros = {5, 3, 6, 2, 10};

        selectionSort(numeros);

        System.out.print("Array ordenado: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}
```

## 📝 Conclusão

- A ordenação por seleção é didática e ajuda a entender algoritmos de ordenação.

- Apesar de simples, não é eficiente para grandes volumes de dados.

- Ideal para fins educacionais ou listas pequenas.