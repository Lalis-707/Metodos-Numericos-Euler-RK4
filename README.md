# Resolución Numérica de EDOs: Método de Euler y Runge-Kutta 4

Implementación modular en Java del Método de Euler y del Método de Runge-Kutta de 4to orden (RK4) para resolver problemas de valor inicial, comparando los resultados contra la solución analítica exacta.

**Materia:** SCC-1017 Métodos Numéricos

**Institución:** Instituto Tecnológico Superior de Xalapa

**Actividad:** Unidad 6, Resolución Numérica de EDOs

## Problemas resueltos

| Método | EDO | Condición inicial | Solución exacta |
|--------|-----|-------------------|-----------------|
| Euler | y' = x − y | y(0) = 1, x ∈ [0, 0.3] | y(x) = x − 1 + 2e^(−x) |
| RK4 | y' = x + y | y(0) = 1, x ∈ [0, 0.3] | y(x) = 2e^x − x − 1 |

Euler se ejecuta con h = 0.1, 0.05 y 0.01. RK4 se ejecuta con h = 0.1.
Para cada paso se muestra el valor aproximado, el valor exacto y el error absoluto |y_exacta − y_n|.

## Fundamento de los métodos

Ambos métodos resuelven un problema de valor inicial y' = f(x, y), y(x₀) = y₀, avanzando paso a paso con un tamaño de paso h. El criterio de paro es el número total de pasos:

```
N = (x_final − x₀) / h
```

### Método de Euler

Es el método más sencillo. En cada paso se usa la pendiente en el punto actual (la recta tangente) para estimar el siguiente valor:

```
y_{n+1} = y_n + h · f(x_n, y_n)
x_{n+1} = x_n + h
```

- Solo evalúa f una vez por paso.
- Error local de orden O(h²) y error global de orden **O(h)**: si se reduce h a la mitad, el error baja aproximadamente a la mitad.
- Es fácil de implementar, pero necesita pasos muy pequeños para ser preciso.

### Método de Runge-Kutta de 4to orden (RK4)

En lugar de usar una sola pendiente, calcula cuatro pendientes dentro del intervalo [x_n, x_n + h] y las promedia con pesos:

```
k1 = f(x_n, y_n)
k2 = f(x_n + h/2, y_n + (h/2)·k1)
k3 = f(x_n + h/2, y_n + (h/2)·k2)
k4 = f(x_n + h,   y_n + h·k3)

y_{n+1} = y_n + (h/6)·(k1 + 2·k2 + 2·k3 + k4)
x_{n+1} = x_n + h
```

- Evalúa f cuatro veces por paso.
- Error local de orden O(h⁵) y error global de orden **O(h⁴)**: si se reduce h a la mitad, el error baja unas 16 veces.
- Con el mismo h es mucho más preciso que Euler.

### Error absoluto

Para comparar contra la solución analítica exacta se calcula en cada paso:

```
Error = |y_exacta(x_n) − y_n|
```

## Resultados observados en x = 0.3

| Método | h | Error absoluto |
|--------|-------|----------------|
| Euler | 0.1 | 0.02363644 |
| Euler | 0.05 | 0.01145266 |
| Euler | 0.01 | 0.00223569 |
| RK4 | 0.1 | 0.00000062 |

El error de Euler disminuye de forma proporcional a h, mientras que RK4 con h = 0.1 ya es varios órdenes de magnitud más preciso que Euler con h = 0.01.

## Estructura del proyecto

```
Ecuaciones_Lineales/
└── Unidad05y06/
    ├── MetodoEuler/
    │   └── MetodoEuler.java
    └── MetodoRungeKutta/
        ├── MetodoRungeKutta.java
        └── Main.java
```

- `MetodoEuler.java`: implementa `evaluarFuncion`, `solucionExacta` y `resolver` para Euler.
- `MetodoRungeKutta.java`: implementa `evaluarFuncion`, `solucionExacta` y `resolver` para RK4.
- `Main.java`: ejecuta Euler (h = 0.1, 0.05 y 0.01) y RK4 (h = 0.1).

## Requisitos

- JDK 11 o superior (verifica con `java -version` y `javac -version`)
- Git

## Clonar el repositorio

```
git clone https://github.com/Lalis-707/Metodos-Numericos-Euler-RK4.git
cd Metodos-Numericos-Euler-RK4
```

## Compilar

Desde la raíz del repositorio (los archivos compilados se guardan en la carpeta `out`):

```
javac -d out Ecuaciones_Lineales/Unidad05y06/MetodoEuler/MetodoEuler.java Ecuaciones_Lineales/Unidad05y06/MetodoRungeKutta/MetodoRungeKutta.java Ecuaciones_Lineales/Unidad05y06/MetodoRungeKutta/Main.java
```

## Ejecutar

```
java -cp out Ecuaciones_Lineales.Unidad05y06.MetodoRungeKutta.Main
```

La salida muestra primero las tablas de Euler (h = 0.1, 0.05 y 0.01) y después la tabla de RK4 (h = 0.1), cada una con las columnas `n`, `x`, valor aproximado, valor exacto y error absoluto.

## Modificar el tamaño de paso

Para probar otros valores de h, edita las llamadas en `Main.java`:

```java
MetodoEuler.resolver(x0, y0, 0.1, xFinal);
MetodoRungeKutta.resolver(x0, y0, 0.1, xFinal);
```

Después vuelve a compilar y ejecutar con los comandos de arriba.
