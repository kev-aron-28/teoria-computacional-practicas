COLOR = {
    'black': 'BLACK',
    'white': 'WHITE'
}
class Cuadrado:
    def __init__(self, id, color):
        self._blancos = []
        self._negros = []
        self._id = id
        self._color = color

    @property
    def blancosAdj(self):
        return self._blancos

    @property
    def negrosAdj(self):
        return self._negros

    @property
    def identificador(self):
        return self._id

    @property
    def color(self):
        return self._color

    @property
    def blancos(self):
        return self._blancos

    @blancos.setter
    def blancos(self, blanco):
        self._blancos = blanco

    @property
    def negros(self):
        return self._negros

    @negros.setter
    def negros(self, negro):
        self._negros = negro

class Arbol:
    def __init__(self,estadofinal,archivoganador, archivomovimientos):
        self.movimientoSeleccionado = ''
        self.todosLosMov = open(archivomovimientos, 'w')
        self.movimientosGanadores = open(archivoganador, 'w')
        self.estadofinal = estadofinal

    def crearArbol(self, cadMovimientos, cuadradoActual, posPatronActMov, actual):
        if posPatronActMov > (len(cadMovimientos) - 1):
            if actual == '':
                actual = actual + str(cuadradoActual.identificador)
            else:
                actual = actual + ' ' + str(cuadradoActual.identificador)
            movimiento = actual.strip() + '\n'
            self.todosLosMov.write(movimiento)

            if actual.endswith(self.estadofinal):
                self.movimientosGanadores.write(movimiento)
                self.movimientoSeleccionado = actual.strip()
        else:
            patronAElegir = cadMovimientos[posPatronActMov]
            if patronAElegir == 'w':
                for cuadradoBlanco in cuadradoActual.blancosAdj:
                    self.crearArbol(
                        cadMovimientos,
                        cuadradoBlanco,
                        posPatronActMov + 1,
                        actual + ' ' + str(cuadradoActual.identificador)
                    )

            if patronAElegir == 'b':
                for cuadradoNegro in cuadradoActual.negrosAdj:
                    self.crearArbol(
                        cadMovimientos,
                        cuadradoNegro,
                        posPatronActMov + 1,
                        actual + ' ' + str(cuadradoActual.identificador)
                    )
class Tablero:
    def __init__(self):
        self.movJugUno = ''
        self.movJugDos = ''
        self.cuadrado1 = Cuadrado(1, COLOR['black'])
        self.cuadrado2 = Cuadrado(2, COLOR['white'])
        self.cuadrado3 = Cuadrado(3, COLOR['black'])
        self.cuadrado4 = Cuadrado(4, COLOR['white'])
        self.cuadrado5 = Cuadrado(5, COLOR['black'])
        self.cuadrado6 = Cuadrado(6, COLOR['white'])
        self.cuadrado7 = Cuadrado(7, COLOR['black'])
        self.cuadrado8 = Cuadrado(8, COLOR['white'])
        self.cuadrado9 = Cuadrado(9, COLOR['black'])
        self.cuadrado10 = Cuadrado(10, COLOR['white'])
        self.cuadrado11 = Cuadrado(11, COLOR['black'])
        self.cuadrado12 = Cuadrado(12, COLOR['white'])
        self.cuadrado13 = Cuadrado(13, COLOR['black'])
        self.cuadrado14 = Cuadrado(14, COLOR['white'])
        self.cuadrado15 = Cuadrado(15, COLOR['black'])
        self.cuadrado16 = Cuadrado(16, COLOR['white'])
        self.build_board()

    def set_player_one_move(self, move):
        self.movJugUno = move

    def set_player_two_move(self, move):
        self.movJugDos = move

    def generate_moves(self):
        if self.movJugUno and not self.movJugDos:
            tree = Arbol('16','ganadores.txt', 'movimientos.txt')
            tree.crearArbol(self.movJugUno, self.cuadrado1, 0, '')
            return {'moveForPlayerOne': tree.movimientoSeleccionado}
        else:
            arboljug1 = Arbol('16', 'ganadores.txt', 'movimientos.txt')
            arboljug2 = Arbol('13', 'ganadores2.txt', 'movimientos2.txt')
            arboljug1.crearArbol(self.movJugUno, self.cuadrado1, 0, '')
            arboljug2.crearArbol(self.movJugDos, self.cuadrado4, 0, '')
            return {
                'moveForPlayerOne': arboljug1.movimientoSeleccionado,
                'moveForPlayerTwo': arboljug2.movimientoSeleccionado
            }

    def build_board(self):
        self.cuadrado1._blancos = [self.cuadrado2, self.cuadrado5]
        self.cuadrado1._negros = [self.cuadrado6]

        self.cuadrado2._blancos = [self.cuadrado5, self.cuadrado7]
        self.cuadrado2._negros = [self.cuadrado1, self.cuadrado3, self.cuadrado6]

        self.cuadrado3._blancos = [self.cuadrado2, self.cuadrado4, self.cuadrado7]
        self.cuadrado3._negros = [self.cuadrado6, self.cuadrado8]

        self.cuadrado4._blancos = [self.cuadrado7]
        self.cuadrado4._negros = [self.cuadrado3, self.cuadrado8]

        self.cuadrado5._blancos = [self.cuadrado2, self.cuadrado10]
        self.cuadrado5._negros = [self.cuadrado1, self.cuadrado6, self.cuadrado9]

        self.cuadrado6._blancos = [self.cuadrado2, self.cuadrado5, self.cuadrado7, self.cuadrado10]
        self.cuadrado6._negros = [self.cuadrado1, self.cuadrado3, self.cuadrado9, self.cuadrado11]

        self.cuadrado7._blancos = [self.cuadrado2, self.cuadrado4, self.cuadrado10, self.cuadrado12]
        self.cuadrado7._negros = [self.cuadrado3, self.cuadrado6, self.cuadrado11, self.cuadrado8]

        self.cuadrado8._blancos = [self.cuadrado4, self.cuadrado7, self.cuadrado12]
        self.cuadrado8._negros = [self.cuadrado3, self.cuadrado11]

        self.cuadrado9._blancos = [self.cuadrado5, self.cuadrado10, self.cuadrado13]
        self.cuadrado9._negros = [self.cuadrado6, self.cuadrado14]

        self.cuadrado10._blancos = [self.cuadrado5, self.cuadrado7, self.cuadrado13, self.cuadrado15]
        self.cuadrado10._negros = [self.cuadrado6, self.cuadrado9, self.cuadrado11, self.cuadrado14]

        self.cuadrado11._blancos = [self.cuadrado7, self.cuadrado12, self.cuadrado15, self.cuadrado10]
        self.cuadrado11._negros = [self.cuadrado6, self.cuadrado8, self.cuadrado14, self.cuadrado16]

        self.cuadrado12._blancos = [self.cuadrado7, self.cuadrado15]
        self.cuadrado12._negros = [self.cuadrado8, self.cuadrado11, self.cuadrado16]

        self.cuadrado13._blancos = [self.cuadrado10]
        self.cuadrado13._negros = [self.cuadrado9, self.cuadrado14]

        self.cuadrado14._blancos = [self.cuadrado13, self.cuadrado10, self.cuadrado15]
        self.cuadrado14._negros = [self.cuadrado9, self.cuadrado11]

        self.cuadrado15._blancos = [self.cuadrado10, self.cuadrado12]
        self.cuadrado15._negros = [self.cuadrado14, self.cuadrado11, self.cuadrado16]

        self.cuadrado16._blancos = [self.cuadrado15, self.cuadrado12]
        self.cuadrado16._negros = [self.cuadrado11]
        
def main():
    board = Tablero()
    board.set_player_one_move("wbbb")
    resultado = board.generate_moves()
    print(resultado)
    

if __name__ == "__main__":
    main()
