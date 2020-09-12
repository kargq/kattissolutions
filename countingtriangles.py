def gimme_slope(line):
  [x1, y1, x2, y2] = line
  return (y2 - y1) / (x2 - x1)

def are_they_intersecto(line1, line2):
  ax1, ay1, ax2, ay2 = line1
  bx1, by1, bx2, by2 = line2
  am = gimme_slope(line1)
  bm = gimme_slope(line2)

  if(am == bm):
    print("Plz no")
    return False

  # Okay they're not parallel... now what

  # Okay they can intersect, but do they?

  # Mission: FIND THAT POINT

  # y = mx + c
  # c = y - mx

  ac = ay1 - am * ax1
  bc = by2 - bm * bx2

  # ze_y = am ze_x + ac
  # ze_y = bm ze_x + bc
  # ze_x = (bc - ac) / (am - bm)

  ze_x = (bc - ac) / (am - bm)
  ze_y = bm * ze_x + bc

  # print('emm')
  # print(line1, line2)
  # print(ze_x, ze_y)

  return ze_x >= min(ax1, ax2) and ze_x <= max(ax1, ax2) and ze_x >= min(bx1, bx2) and ze_x <= max(bx1, bx2) and \
    ze_y >= min(ay1, ay2) and ze_y <= max(ay1, ay2) and ze_y >= min(by1, by2) and ze_y <= max(by1, by2)


n = int(input())

while(n != 0):
  lines = [tuple(float(a) for a in input().split(" ")) for _ in range(n)]
  # print(lines)
  count = 0
  for i in range(n):
    for j in range(i + 1, n):
      for k in range(j + 1, n):
        if are_they_intersecto(lines[i], lines[j]) and are_they_intersecto(lines[j], lines[k]) and are_they_intersecto(lines[k], lines[i]):
          count += 1

  print(count)
        
  n = int(input())
