use DBI;
use strict;

my $driver   = "SQLite"; 
my $dbName = "test.db";
my $dsn = "DBI:$driver:dbname=$dbName";
my $userid = "";
my $password = "";
my $dbh = DBI->connect($dsn, $userid, $password) or die $DBI::errstr;

print "Opened database successfully\n";

my $stmt = qq(CREATE TABLE COMPANY(
    ID INT PRIMARY KEY NOT NULL,
    NAME    TEXT    NOT NULL,
    AGE     TEXT    NOT NULL,
    ADDRESS     CHAR(50),
    SALARY  REAL););

my $rv = $dbh->do($stmt);

if($rv < 0){
    print $DBI::errstr;
} else{
    print "Table created";
}

$stmt = qq(SELECT id, name, address, salary from COMPANY;);
my $sth = $dbh->prepare($stmt);
my $rv = $sth->execute() or die $DBI::errstr;

$stmt = qq(UPDATE COMPANY set SALARY = 250234000.0 where ID = 1;);
$rv = $dbh ->do($stmt) or die $DBI::errstr;

$stmt = qq(DELETE from COMPANY where ID = 1;);
$rv = $dbh->do($stmt) or die $DBI::errstr;

while(my @row=$sth->fetchrow_array()){
    print "ID = ".$row[0]."\n";
    print "NAME = ".$row[1]."\n";
    print "ADDRESS = ".$row[2]."\n";
    print "SALARY = ".$row[3]."\n";
}

if( $rv < 0 ) {
   print $DBI::errstr;
} else {
   print "Total number of rows updated : $rv\n";
}

while(my @row=$sth->fetchrow_array()){
    print "ID = ".$row[0]."\n";
    print "NAME = ".$row[1]."\n";
    print "ADDRESS = ".$row[2]."\n";
    print "SALARY = ".$row[3]."\n";
}

$dbh->disconnect();