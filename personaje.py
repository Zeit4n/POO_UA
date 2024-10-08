from equipamiento import Espada, Escudo
import random
class Personaje():
    def __init__(self, nombre:str, salud:int, velocidad:int, espada:object, escudo:object):
        self.nombre = nombre
        self.salud = salud
        self.velocidad = velocidad
        self.espada = espada
        self.escudo = escudo
        self.muerto = False
    #Método que permite al personaje ejecutar ataques
    def atacar(self):
        self.espada.activar_afinidad()
        if self.espada.critico == True:
            print("Buen golpe!")
            return round(self.espada.poder*random.randint(85,100)/100*1.5)
        else:
            return round(self.espada.poder*random.randint(85,100)/100)

    #Método que permite calcular el daño que recibirá el personaje
    def recibir_daño(self, at_opo):
        self.escudo.activar_dureza()
        if self.escudo.super_def == True:
            print("Buen bloqueo!")
            daño = round(at_opo - self.escudo.defensa*random.randint(75,100)/100*1.25)            
        else:
            daño = round(at_opo - self.escudo.defensa*random.randint(75,100)/100)

        if daño < self.salud:
            self.salud = self.salud - daño
            print(f"{self.nombre} ha perdido {daño} puntos de salud.")
        else:
            self.muerto = True
            print(f"{self.nombre} ha perdido {self.salud} puntos de salud.")
            self.salud = 0
            print(f"El personaje {self.nombre} ha muerto.")

    def __str__(self):
        return f"Nombre: {self.nombre}\tSalud: {self.salud}"

if __name__ == "__main__":
    esp1 = Espada('Valkiria', 120, 2)
    esp2 = Espada('Filo Sombrío', 90, 4)
    esp3 = Espada('Brëhmuren', 140, 1)
    esc1 = Escudo('Escudo de Oficial', 40, 1)
    esc2 = Escudo('Tabla Férrea', 60, 3)
    esc3 = Escudo('Pétrea Eternidad', 50, 5)
    Juan = Personaje('Juan', 1000, 10, esp1, esc2)
    Jose = Personaje('Jose', 1000,  8, esp3, esc1)
    Juan.salud = 800
    print(Juan.salud)
        
