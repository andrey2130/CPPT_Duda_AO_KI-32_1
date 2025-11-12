# lab6_matrix.py
# Модуль для створення зубчастого списку (заштрихована права нижня частина квадратної матриці)

def generate_jagged_matrix(n, symbol):
    """
    Генерує зубчастий список, який містить лише заштриховану область квадратної матриці —
    праву нижню половину (включно з головною діагоналлю).
    """
    jagged_list = []

    for i in range(n):
        # Зліва ставимо пробіли, щоб утворити діагональ
        row = [" "] * (n - i - 1) + [symbol] * (i + 1)
        jagged_list.append(row)

    return jagged_list


def print_matrix(matrix):
    """Друкує зубчастий список у вигляді матриці."""
    for row in matrix:
        print(" ".join(row))
