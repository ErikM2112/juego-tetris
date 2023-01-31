class Tetris {

    val tablero = Array(20) { IntArray(10) }
    var piezaActual = generarPieza()
    val tablero = Array(20) { IntArray(10) }
    var piezaActual = generarPieza()

    fun generarPieza(): Pieza {
        // Generar una pieza al azar
        val tipoPieza = Random.nextInt(7)
        return when (tipoPieza) {
            0 -> PiezaI()
            1 -> PiezaJ()
            2 -> PiezaL()
            3 -> PiezaO()
            4 -> PiezaS()
            5 -> PiezaT()
            else -> PiezaZ()
        }
    }

    fun moverPiezaAbajo() {
        // Comprobar si la pieza puede moverse hacia abajo
        if (puedeMoverse(piezaActual, 0, 1)) {
            piezaActual.moverAbajo()
            actualizarTablero()
        } else {
            generarNuevaPieza()
        }
    }

    fun rotarPieza() {
        // Rotar la pieza actual
        val nuevaOrientacion = (piezaActual.orientacion + 1) % piezaActual.numOrientaciones
        val nuevaPieza = piezaActual.crearCopia(nuevaOrientacion)
        // Comprobar si la nueva posición es válida
        if (puedeMoverse(nuevaPieza)) {
            piezaActual = nuevaPieza
            actualizarTablero()
        }
    }

    fun moverPiezaIzquierda() {
        // Comprobar si la pieza puede moverse hacia la izquierda
        if (puedeMoverse(piezaActual, -1, 0)) {
            piezaActual.moverIzquierda()
            actualizarTablero()
        }
    }

    fun moverPiezaDerecha() {
        // Comprobar si la pieza puede moverse hacia la derecha
        if (puedeMoverse(piezaActual, 1, 0)) {
            piezaActual.moverDerecha()
            actualizarTablero()
        }
    }

    fun actualizarTablero() {
        // Recorrer el tablero y actualizar la posición de cada celda
        // según la posición de la pieza actual
        for (i in 0 until 20) {
            for (j in 0 until 10) {
                tablero[i][j] = 0
            }
        }
        for (i in 0 until 4) {
            for (j in 0 until 4) {
                if (piezaActual.forma[piezaActual.orientacion][i][j] != 0) {
                    tablero[piezaActual.y + i][piezaActual.x + j] = piezaActual.forma[piezaActual.orientacion][i][j]
                }
            }
        }
    }

    fun generarNuevaPieza() {
        piezaActual
// Comprobar si se ha formado alguna línea completa
        comprobarLineasCompletas()
// Generar una nueva pieza
        piezaActual = generarPieza()
// Comprobar si la nueva pieza se solapa con alguna celda ocupada
        if (!puedeMoverse(piezaActual)) {
// Fin del juego
            gameOver()
        }
    }

    fun comprobarLineasCompletas() {
// Recorrer cada fila del tablero
        for (i in 0 until 20) {
// Comprobar si todas las celdas de la fila están ocupadas
            if (tablero[i].all { it != 0 }) {
// Eliminar la fila y desplazar hacia abajo las filas superiores
                for (j in i downTo 1) {
                    tablero[j] = tablero[j - 1]
                }
                tablero[0] = IntArray(10)
// Aumentar el número de líneas eliminadas
                aumentarLineasEliminadas()
            }
        }
    }

    fun gameOver() {
// Mostrar un mensaje de fin de juego y detener el juego
    }

    fun aumentarLineasEliminadas() {
// Aumentar el número de líneas eliminadas y actualizar la puntuación
    }

}

class Pieza {

}

fun gameOver() {
    println("Game over!")
// detener el juego
}

fun aumentarLineasEliminadas() {
    var lineasEliminadas = 0
    lineasEliminadas++
// actualizar la puntuación
}

fun puedeMoverse(pieza: Pieza, dx: Int, dy: Int): Boolean {
    for (i in 0 until 4) {
        for (j in 0 until 4) {
            if (pieza.forma[pieza.orientacion][i][j] != 0) {
                val nx = pieza.x + j + dx
                val ny = pieza.y + i + dy
                if (nx < 0 || nx >= 10 || ny < 0 || ny >= 20 || tablero[ny][nx] != 0) {
                    return false
                }
            }
        }
    }
    return true
}

//función para iniciar el juego
fun iniciarJuego() {
// inicializar el tablero
    for (i in 0 until 20) {
        for (j in 0 until 10) {
            tablero[i][j] = 0
        }
    }
// generar la primera pieza
    piezaActual = generarPieza()
// iniciar el bucle del juego
    while (true) {
// mover la pieza hacia abajo cada cierto tiempo
        Thread.sleep(1000)
        moverPiezaAbajo()
    }
}

}

fun main(args: Array<String>) {
val juego = Tetris()
juego.iniciarJuego()
}




