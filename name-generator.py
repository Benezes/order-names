import sys
from faker import Faker


def validate_name(name):
    return (
        not name.__contains__("Dr")
        and not name.__contains__("Ms")
        and not name.__contains__("Mr")
        and not name.__contains__("Miss")
    )


def gen_name(quantity):
    fake = Faker()
    names = set()
    while len(names) < quantity:
        name = fake.name()
        if validate_name(name):
            names.add(name)
    return list(names)


if __name__ == "__main__":
    if len(sys.argv) > 1:
        try:
            quantity = int(sys.argv[1])
        except ValueError:
            print("Invalid quantity specified. Please provide a valid integer.")
            sys.exit(1)
    else:
        print("Please specify the quantity of names as a command-line argument.")
        sys.exit(1)

    names = gen_name(quantity)

    with open("sorted-names-list.txt", "w") as f:
        for name in names:
            f.write(f"{name}\n")
