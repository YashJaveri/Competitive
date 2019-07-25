use Data::Dumper;

%data = ("Pratik", 20, "Yash", 'infinite');

print Dumper(\%data);
print "Without '\\':\n";
print Dumper(%data);ß