def solution(grid):
    answer = []
    cycleChk = [[[False for _ in range(4)] for _ in range(len(grid[0]))] for _ in range(len(grid))]
    xsize, ysize = len(grid[0]), len(grid)

    # find cycle for all point
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            for d in range(4):
                if not cycleChk[i][j][d]:
                    cnt = 0
                    direction = ((0, 1), (1, 0), (0, -1), (-1, 0))
                    now = (i, j, d)
                    while True:
                        if cycleChk[now[0]][now[1]][now[2]]:
                            break
                        else:
                            cnt += 1
                            cycleChk[now[0]][now[1]][now[2]] = True
                            ny, nx, nd = now
                            if grid[ny][nx] == 'L':
                                nd = (nd - 1 + 4) % 4
                            elif grid[ny][nx] == 'R':
                                nd = (nd + 1 + 4) % 4
                            ny = (ny + direction[nd][0] + ysize) % ysize
                            nx = (nx + direction[nd][1] + xsize) % xsize
                            now = (ny, nx, nd)
                    answer.append(cnt)
    answer.sort()
    return answer