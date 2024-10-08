import random
class Espada():
    def __init__(self, nombre:str, poder:int, afinidad:int):
        self.nombre = nombre
        self.poder = poder
        self.afinidad = afinidad
        self.critico = False
    
    #Función que puede activar la capacidad de la espada de realizar golpe crítico
    def activar_afinidad(self):
        if self.afinidad >= random.randint(1,10):
            self.critico = True
        else:
            self.critico = False
            
    def __str__(self):
        return f"Nombre: {self.nombre}\tPoder: {self.poder}\tAfinidad: {self.afinidad*10}%"

class Escudo():
    def __init__(self, nombre:str, defensa:int, dureza:int):
        self.nombre = nombre
        self.defensa = defensa
        self.dureza = dureza   
        self.super_def = False

    #Función que puede activar la capacidad del escudo de realizar super defensa
    def activar_dureza(self):
        if self.dureza >= random.randint(1,10):
            self.super_def = True
        else:
            self.super_def = False       

    def __str__(self):
        return f"Nombre: {self.nombre}\tDefensa: {self.defensa}\tDureza: {self.dureza*10}%"
