from PIL import Image

im = Image.new("RGB", (1024, 1024))
pic = im.load()

pos1 = 0
pos2 = 1024
count = 0

while pos1 < 512:
	for x in range(pos1, pos2):
		i = 0
		for y in range(pos1, pos2):
			pic[y, x] = (i, i, i)
		
			count = count + 1
			if count == 4:
				i = i + 1
				count = 0

	pos1 = pos1 + 1
	pos2 = pos2 - 1

im.save("pyramid.png", "PNG")
