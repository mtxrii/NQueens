def placeQueen(B, i, j):
        B[i][j] += 1
        B[i][0] = j

        down = j
        # vertical downwards queen line of sight
        for k in range(len(B)):
            if k != i:
                B[k][down] -= 1

        # diagonal downwards queen line of sight
        for l in range(len(B)):
            rightClear = (i + l < len(B)) and (j + l < len(B))
            leftClear  = (i + l < len(B)) and (j - l > 0)

            right = j + l
            left = j - l
            if rightClear:
                B[i + l][right] -= 1
            if leftClear:
                B[i + l][left] -= 1


def removeQueen(B, i, j):
    B[i][j] -= 1
    B[i][0] = 0

    down = j
    # vertical downwards queen line of sight
    for k in range(len(B)):
        if k != i:
            B[k][down] += 1

    # diagonal downwards queen line of sight
    for l in range(len(B)):
        rightClear = (i + l < len(B)) and (j + l < len(B))
        leftClear  = (i + l < len(B)) and (j - l > 0)

        right = j + l
        left = j - l
        if rightClear:
            B[i + l][right] += 1
        if leftClear:
            B[i + l][left] += 1


def findSolutions(B, i, mode):
    n = len(B)-1
    v = False
    if mode == "verbose":
        v = True

    printer = "("

    if i > n:
        if v:
            for e in range(len(B)):
                printer += str(B[e][0])
                if e != n:
                    printer += ", " #if not at end, keep adding separators to text
            printer += ")"
            print(printer)

        B[0][0] += 1
        return 1

    else:
        for j in range(len(B)):
            if B[i][j] == 0:
                placeQueen(B, i, j)
                findSolutions(B, i+1, mode)
                removeQueen(B, i, j)

    return B[0][0]


def printBoard(B):
    sol = None
    if B[0][1] == 1:
        sol = findSolutions(B, 1, "verbose")
    else:
        sol = findSolutions(B, 1, "")
    print(str((len(B) - 1)) + "-Queens has " + str(sol) + " solutions")

def main(args):
    usage = "Usage: Queens [-v] number \nOption: -v verbose output, print all solutions"

    if len(args) < 1:
        print(usage)
        return

    ns = "" # string that holds n
    v = None

    if len(args) == 1:
        v = False
        ns = args[0]

    else:
        if not args[0] == "-v":
            print(usage)
            return

        v = True
        ns = args[1]

    n = 0

    try:
        n = int(ns)
    except ValueError:
        print(usage)
        return

    # Parsing finished.
    # Create board & run other methods.
    B = []
    for n1 in range(n+1):
        B_mini = []
        for n2 in range(n+1):
            B_mini.append(0)
        B.append(B_mini)

    # Put a T/F (1/0) in B[0][1] to indicate mode
    if v:
        B[0][1] = 1
    else:
        B[0][1] = 0

    printBoard(B)


if __name__ == "__main__":
    # execute only if run as a script
    args = input("Queens ").split(" ")
    main(args)