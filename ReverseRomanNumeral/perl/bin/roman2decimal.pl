#!/usr/pkg/bin/perl

use warnings;
use strict;

sub roman2decimal {
	my ($roman) = @_;
	my $decimal = 0;
	foreach (split //, $roman) {
		$decimal += digit2decimal($_);
	}
	return $decimal;
}

sub digit2decimal {
	my ($roman_digit) = @_;
	my %known_digits = (
		I	=> 1,
		V	=> 5,
	);
	return 0 unless exists $known_digits{$roman_digit};
	return $known_digits{$roman_digit};
}

roman2decimal(@ARGV) unless caller();

1;
