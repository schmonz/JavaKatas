#!/usr/pkg/bin/perl

use warnings;
use strict;

sub roman2decimal {
	my ($roman) = @_;
	my $decimal = 0;
	my $previous = 0;
	foreach my $roman_digit (reverse split //, $roman) {
		my $decimal_digit = digit2decimal($roman_digit);
		if ($decimal_digit < $previous) {
			$decimal -= $decimal_digit;
		} else {
			$decimal += $decimal_digit;
		}
		$previous = $decimal_digit;
	}
	return $decimal;
}

sub digit2decimal {
	my ($roman_digit) = @_;
	my %known_digits = (
		I	=> 1,
		V	=> 5,
		X	=> 10,
		L	=> 50,
		C	=> 100,
		M	=> 1000,
	);
	return 0 unless exists $known_digits{$roman_digit};
	return $known_digits{$roman_digit};
}

roman2decimal(@ARGV) unless caller();

1;
