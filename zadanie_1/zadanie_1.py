# zmienne i nazwy funckji są po polsku bo chciałem się trzymać jednej konwencji przez cały plik
import queue


class Kolejka:
    def __init__(self, lista=[]):
        self.lista = lista

    def dodaj(self, przedmiot):
        self.lista.append(przedmiot)

    def wyjmij(self):
        try:
            przedmot = self.lista[0]
            self.lista.pop(0)
            return przedmot
        except IndexError:
            print("Kolejka jest pusta")

    def __repr__(self) -> str:
        return str(self.lista)


class Zajecia:
    def __init__(self, studenci_lista=[]):
        self.studenci_lista = studenci_lista

    def zapisz_studenta(self, student):
        if (len(self.studenci_lista) < 10):
            print(len(self.studenci_lista))
            self.studenci_lista.append(student)
        else:
            print("Nie dokonano zapisu, osiągnięto maksymalną ilość uczestników zajęć")

    def __repr__(self):
        return str(self.studenci_lista)


def zapisz_do_pliku():
    with open("procedura.txt", "a") as file:
        file.write(input("Napisz co chcesz żeby było zapisane do pliku ")+"\n")


def cena_netto(cena_brutto, stawka_podatku):
    # sprawdzam czy stawka podatku została podana jako liczba od 0 do 1  czy jako procent  i czy użytkownik podał poprawnie dane
    try:
        stawka_podatku = float(stawka_podatku)
        if (stawka_podatku > 1.0):
            # nie jestem pewien czy powinienem to zaokrąglać
            stawka_podatku = stawka_podatku/100
    except ValueError:
        return r"Podaj liczbę w formacie 0.23 lub 23 bez znaku % ani żadnych innych znaków tylko cyfry"

    return round(cena_brutto/(1+stawka_podatku), 4)


print("start")
print(cena_netto(100, "23%"))
print(cena_netto(100, 23))
print(cena_netto(100, 0.23))
# implementacja z gotowej biblioteki zdecydowanie bardziej optymalna i ma więcej funkcjonalności niż ta z implementacji autorskiej Kolejka
q = queue.Queue()
q.put(1)
q.put("abc")
q.put(2)
q.put(3)
print(q.get())
print(q.get())
print(q.get())

k = Kolejka()
k.dodaj(1)
k.dodaj("abc")
k.dodaj(2)
k.dodaj(3)
print(k)
print(k.wyjmij())
print(k)

zapisz_do_pliku()

wyklad = Zajecia(["1", "2", "3", "4", "5", "6", "7", "8"])
wyklad.zapisz_studenta("9")
print(wyklad)
wyklad.zapisz_studenta("10")
wyklad.zapisz_studenta("11")
print(wyklad)

