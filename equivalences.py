# This is too slow
cases = int(input())


def get_sccs(graph, n):
    index = 0
    stack = []
    ind = [None] * n
    lowlink = [None] * n
    onStack = [False] * n

    def strongconnect(v, res):
        nonlocal index
        print(index, ind, lowlink)
        ind[v] = index
        lowlink[v] = index
        index += 1

        stack.append(v)
        onStack[v] = True

        for w in graph[v]:
            print("rec check", ind, ind[w], v, w)
            if not ind[w]:
                strongconnect(w, res)
                lowlink[v] = min(lowlink[v], lowlink[w])
            elif onStack[w]:
                lowlink[v] = min(lowlink[v], ind[w])
        
        print("oooooooooo", index, ind, lowlink)


        if lowlink[v] == ind[v]:
            print('Start poppin')
            while True:
                w = stack.pop()
                onStack[w] = False
                res.append(w)
                if w == v:
                    break

    sccs = []
    
    for v in graph:
        if not ind[v]:
            res = []
            strongconnect(v, res)
            print("res", res)
            sccs.append(res)

    print(sccs)

    return sccs


def has_out(g, scc):
    for x in scc:
        for nbr in g[x]:
            if nbr not in scc:
                return True

    return False


def has_in(g, scc):
    for start in g:
        if start not in scc:
            for end in g[start]:
                if end in scc:
                    return True

    return False


for _ in range(cases):
    [n, m] = [int(x) for x in input().strip().split()]

    g = {}
    # gc = {}

    for i in range(n):
        g[i] = set()
        # gc[i] = set()

    for _ in range(m):
        [s1, s2] = [int(x) for x in input().strip().split()]
        s1 -= 1
        s2 -= 1
        g[s1].add(s2)
        # gc[s2].add(s1)

    print("Graph:", g)
    sccs = get_sccs(g, n)

    total_out = 0
    total_in = 0

    for scc in sccs:
        if not has_in(g, scc):
            total_in += 1

        if not has_out(g, scc):
            total_out += 1

    print(max(total_out, total_in))
