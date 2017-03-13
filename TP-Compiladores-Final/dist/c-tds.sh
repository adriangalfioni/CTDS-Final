echo "Compiling program"

java -jar TP-Compiladores.jar $1 | grep error

echo "I3D File genearated at: 'i3d.txt'"

echo "Assembly output file: 'asm.s'"

gcc -m32 asm.s -o b.out

echo "Done compiling!"

echo "Executing program"

./b.out

echo "Done! No errors found"

