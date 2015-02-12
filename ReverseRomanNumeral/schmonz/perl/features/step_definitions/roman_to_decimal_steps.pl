#!/usr/pkg/bin/perl

use warnings;
use strict;

use Test::BDD::Cucumber::StepFile;

use Test::More;

require 'bin/roman2decimal.pl';

Given qr/^the Roman numeral (.+)$/, sub {
	S->{roman} = $1;
};

When qr/^it is converted to decimal$/, sub {
	S->{decimal} = roman2decimal(S->{roman});
};

Then qr/^its value is ([0-9]+)$/, sub {
	is(S->{decimal}, $1);
};
