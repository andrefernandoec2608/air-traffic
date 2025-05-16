# 🎓 ELTE Master's Degree 2025 – Programming Problem

Este proyecto fue desarrollado como parte del proceso de admisión para el programa de Maestría en Informática de **ELTE (Eötvös Loránd University)**.

## 📄 Descripción

El objetivo del ejercicio es procesar un archivo de texto que contiene datos sobre los vuelos diarios que salen del aeropuerto de Budapest. Cada línea contiene:

- ✈️ Nombre de la aerolínea
- 🌍 Ciudad de destino
- 👥 Número de pasajeros

El archivo está ordenado por aerolínea en orden alfabético ascendente. El programa debe analizar los datos y responder a 4 ejercicios específicos.

## 🚀 Ejecución

Este proyecto no utiliza una estructura compleja. Solo contiene:

- Un archivo Java principal: `Problem1.java`
- Un archivo de entrada: `input.txt`

Para ejecutar el programa:

```bash
# Asegúrate de tener Java 17 o superior
javac Problem1.java
java Problem1
```

El programa comienza en el método `main` de la clase `Problem1`. El archivo `input.txt` debe estar en el mismo directorio que el `.java`.

## ✅ Requisitos Técnicos

- Mínimo Java 8, recomendado Java 17 o superior (LTS)
- Entrada estándar o archivo `input.txt`
- Salida a consola estándar

---

## 📚 Enunciado del Problema

Dado un archivo que contiene datos de tráfico aéreo diario del aeropuerto de Budapest. Cada línea contiene dos cadenas y un número entero separados por espacios:

```
<NombreAerolinea> <Destino> <CantidadPasajeros>
```

Ejemplo de contenido:

```
Alitalia Rome 180
Alitalia Pisa 82
Germanwings Munich 96
Germanwings Frankfurt 163
NorwegianAir Bergen 202
Wizzair London 184
Wizzair Frankfurt 83
Wizzair Lisbon 198
```

### ✏️ Ejercicios

1. ¿Cuántos vuelos hay hacia "Frankfurt"?
2. ¿Qué vuelo transportó más pasajeros?
3. ¿Cuál es el primer vuelo con menos de 100 pasajeros?
4. ¿Cuál aerolínea transportó el mayor número total de pasajeros? (Imprimir nombre y total)

---

## 📥 Ejemplo de Entrada y Salida

### 🧪 Entrada

```
Alitalia Rome 180
Wizzair Cracow 100
Wizzair Barcelona 150
```

### 📤 Salida esperada

```
0
Alitalia Rome 180
There is no flight with passengers less than 100.
Wizzair 250
```

---

## 👨‍💻 Autor
[![LinkedIn](https://img.shields.io/badge/LinkedIn-André%20Llumiquinga-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/andre-llc/)  
[![GitHub](https://img.shields.io/badge/GitHub-André%20Llumiquinga-black?style=flat&logo=github)](https://github.com/andrefernandoec2608)