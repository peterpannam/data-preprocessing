infile = open("pycharm.arff", "r")
outfile = open("boolean.arff", "w+")

lines = []

infile.readline()
count_found = 1
count_lost = 1

for new_line in infile:
    parts = new_line.split(',')

    if parts[7] == "?":
        count_found += 1
        parts[7] = "0"
        outfile.write("{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}".format(parts[0], parts[1], parts[2],
                                                                                     parts[3], parts[4], parts[5],
                                                                                     parts[6], parts[7], parts[8],
                                                                                     parts[9], parts[10], parts[11],
                                                                                     parts[12], parts[13], parts[14],
                                                                                     parts[15], parts[16], parts[17]))
    else:
        count_lost += 1
        parts[7] = "1"
        outfile.write("{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}".format(parts[0], parts[1], parts[2],
                                                                                     parts[3], parts[4], parts[5],
                                                                                     parts[6], parts[7], parts[8],
                                                                                     parts[9], parts[10], parts[11],
                                                                                     parts[12], parts[13], parts[14],
                                                                                     parts[15], parts[16], parts[17]))

print(count_found)
print(count_lost)
infile.close()
outfile.close()
