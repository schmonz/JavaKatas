#!/usr/pkg/bin/perl

use warnings;
use strict;

sub roman2decimal {
	my ($roman) = @_;
	return length $roman;
}

roman2decimal(@ARGV) unless caller();

1;
