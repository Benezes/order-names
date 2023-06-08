from faker import Faker


def validate_name(name):
    return (
        not name.__contains__("Dr")
        and not name.__contains__("Ms")
        and not name.__contains__("Mr")
        and not name.__contains__("Miss")
    )


def gen_name():
    fake = Faker()
    names = set()
    qtd_names = int(input("How many names do you want? "))
    while len(names) < qtd_names:
        name = fake.name()
        if validate_name(name):
            names.add(name)
    return list(names)


with open("sorted-names-list.txt", "w") as f:
    names = gen_name()
    for name in names:
        f.write(f"{name}\n")
