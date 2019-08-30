open(FILE,  ">>test.txt") or die "COULD NOT OPEN THE FILE\n";

say FILE "The text was appended to the file";

open(FILE,  "<test.txt") or die "COULD NOT OPEN THE FILE\n";
while(<FILE>) {
   print "$_";
}
close FILE;