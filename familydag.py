import sys

graph = {}
vertices = set()

# parent begat child


def dfs(graph, vertices, info, visited, start):
    visited.add(start)
    for vertex in vertices:
        rel_times = checkRel(graph, start, vertex)
        if rel_times > 0:
            [addInfo(info, vertex) for _ in range(rel_times)]
            if vertex not in visited:
                dfs(graph, vertices, info, visited, vertex)


def addInfo(info, to):
    if to in info:
        info[to] = info[to] + 1
    else:
        info[to] = 1


def addRel(graph, child, parent):
    if (child, parent) in graph:
        graph[(child, parent)] = graph[(child, parent)] + 1
    else:
        graph[(child, parent)] = 1


def checkRel(graph, child, parent):
    return graph[(child, parent)] if (child, parent) in graph else 0


def doStuff():
    hillbilly = set()
    paradox = set()
    for start in vertices:
        info = {}
        dfs(graph, vertices, info, set(), start)
        if start in info:
            paradox.add(start)
        for key in info:
            if info[key] > 1:
                hillbilly.add(start)
    output(hillbilly, paradox)


def output(hillbilly, paradox):
    combined = []

    for para in paradox:
        combined.append((para, "paradox"))
    for hill in hillbilly:
        if hill not in paradox:
            combined.append((hill, "hillbilly"))

    combined.sort(key=lambda a: a[0])

    res = "\n".join([" ".join(t) for t in combined])

    print("\n" if res == "" else res + "\n\n", end="")


def cleanStuff():
    graph.clear()
    vertices.clear()


for _line in sys.stdin:
    line = _line.strip()

    if line == "done":
        doStuff()
        cleanStuff()
    else:
        [parent, child] = [x for x in line.split(" begat ")]
        vertices.add(parent)
        vertices.add(child)
        addRel(graph, child, parent)
