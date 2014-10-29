	# Ethernet

An ethernet simulator written in Java, for CIS*2460


	## To compile

	javac *.java

	## To run

	/*	INPUT:
	 	seed is the seed of a random number generator (if seed = 0, a random seed is used)
		N is the number of devices
		#frames is the number of arriving frames to be simulated
		arrival_rate is the mean number of arrival frames per 100 slot times
	*/
	java Ethernet seed N #frames arrival_rate
	/*	OUTPUT:
		A table with info about the current simulation will be shown,
		Main events will be echoed as they are simulated,
		and following the simulation, a report will be shown which includes:
			- The number of bytes successfully transmitted
			- The total number of frames dropped
			- The Ethernet throughput in bits per second (bps)
			(The throughput is defined as the total number of frame bits successfully transmitted divided by the total simulation time)
