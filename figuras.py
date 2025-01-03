from abc import ABC, abstractmethod

class FiguraGeometrica(ABC):
    def __init__(self):
        pass

    @abstractmethod
    def calcularArea(self):
        pass
    
    @abstractmethod
    def calcularPerimetro(self):
        pass

class Rectangulo(FiguraGeometrica):
    def __init__(self,largo:int,ancho:int):
        self.largo = largo
        self.ancho = ancho
    
    def calcularArea(self):
        area = self.largo * self.ancho
        return print(f'El área de este rectángulo es {area}.')
    
    def calcularPerimetro(self):
        perimetro = 2 * (self.largo + self.ancho)
        return print(f'El perímetro de este rectángulo es {perimetro}.')
    
    def __str__(self):
        return f'DIMENSIONES DEL RECTÁNGULO:\nLARGO: {self.largo}\nANCHO: {self.ancho}'
    
class Triangulo(FiguraGeometrica):
    def __init__(self,base:int,altura:int):
        self.base = base
        self.altura = altura

    def calcularArea(self):
        area = (self.base * self.altura)/2
        return print(f'El área de este triángulo es {area}.')
    
    def calcularPerimetro(self,categoria:str):
        if categoria == 'equilátero':
            perimetro = 3*self.base
        elif categoria == 'isósceles':
            perimetro = (4*self.altura**2 + self.base**2)**(1/2) + self.base
        elif categoria == 'escaleno':            
            return print('No es posible calcular el perímetro con base y altura para este tipo de triángulo.')
        else:
            return print('La categoría de triángulo ingresada no es válida')
        return print(f'El perímetro de este triángulo es {perimetro}.')
    
    def __str__(self):
        return f'DIMENSIONES DEL TRIÁNGULO:\nBASE: {self.base}\nALTURA: {self.altura}\nPOSIBLES CATEGORÍAS:\n- equilátero\n- isósceles\n- escaleno'
    
class Circulo(FiguraGeometrica):
    def __init__(self,radio:int):
        self.radio = radio

    def calcularArea(self):
        area = 3.14*self.radio**2
        return print(f'El área de este círculo es {area}.')
    
    def calcularPerimetro(self):
        perimetro = 2*3.14*self.radio
        return print(f'El perímetro de este círculo es {perimetro}.')
    
    def __str__(self):
        return f'DIMENSIONES DEL CÍRCULO:\nRADIO: {self.largo}'
    
if __name__ == "__main__":
    r1 = Rectangulo(6,7)
    t1 = Triangulo(8,5)
    r1.calcularPerimetro()