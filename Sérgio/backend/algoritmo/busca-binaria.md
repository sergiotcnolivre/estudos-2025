# 📘 Busca Binária em Java

## 🔍 O que é Busca Binária?

A **busca binária** é um algoritmo eficiente para encontrar um elemento em uma **lista ordenada**.  
Ela funciona dividindo repetidamente a lista pela metade até encontrar o valor desejado (ou concluir que ele não existe).

---

## ⚙️ Como funciona?

1. Defina os índices `início` e `fim` da lista.
2. Calcule o **meio**: `meio = (início + fim) / 2`
3. Compare o valor no meio com o valor buscado:
   - Se for igual, encontrou! ✅
   - Se o valor for menor, procure na **metade direita** (ajuste `início = meio + 1`)
   - Se o valor for maior, procure na **metade esquerda** (ajuste `fim = meio - 1`)
4. Repita até `início > fim`.

---

## 🧪 Exemplo em Java

```java
public class BuscaBinaria {

    // Método de busca binária
    public static int buscar(int[] array, int valor) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (array[meio] == valor) {
                return meio; // Valor encontrado
            } else if (array[meio] < valor) {
                inicio = meio + 1; // Buscar na metade direita
            } else {
                fim = meio - 1; // Buscar na metade esquerda
            }
        }

        return -1; // Valor não encontrado
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 7, 9, 11, 13, 15};

        int valorProcurado = 7;
        int resultado = buscar(numeros, valorProcurado);

        if (resultado != -1) {
            System.out.println("Valor encontrado na posição: " + resultado);
        } else {
            System.out.println("Valor não encontrado.");
        }
    }
}
```

## ✅ Observações

- A lista deve estar ordenada para a busca binária funcionar corretamente.

- O tempo de execução é O(log n), muito mais eficiente do que a busca linear em grandes listas.

- Em listas pequenas, a diferença de desempenho pode ser pequena em relação à busca linear.

- A busca binária pode ser implementada de forma iterativa ou recursiva.

- Muito usada em problemas de algoritmos, entrevistas técnicas e estruturas de dados como árvores binárias.
