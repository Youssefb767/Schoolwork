/*------------------------------------------------------------------*/
/* Youssef Boujebha                                                 */
/* Lab 5                                                            */
/* Figure the perimeter and area of a polygon                       */
/* surrounded by a circle                                           */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define INFILE "lab5.dat"
#define OUTFILE "lab5.txt"

int main(void)
{
	double radius, nsides, perimeter, area;
	FILE *data_file; 
    FILE *answer_file;

	// Enter the fopen for the INFILE, with error checking
	data_file = fopen(INFILE , "r");
	if(data_file == NULL){
        printf("Error on opening the input file\n");
        exit (EXIT_FAILURE);
    }

	// Enter the fopen for the OUTFILE, with error checking
	answer_file = fopen(OUTFILE, "w");
    if(answer_file == NULL){
        printf("Error on opening the output file\n");
        exit (EXIT_FAILURE);
    }

	fprintf(answer_file, "\nYoussef Boujebha.  Lab 5.\n\n");
	fprintf(answer_file, "            Number      Perimeter      Area Of  \n");
	fprintf(answer_file, " Radius    Of Sides    Of Polygon      Polygon  \n");
	fprintf(answer_file, "--------   --------   ------------   ----------- \n");
	
	
	//Set up a while loop to do 3 tasks. See directions for  details.
    //While((fscanf(...,&radius, &nsides)) == 2)
    //Compute perimeter, area, then fprintf the radius, nsides, perimeter, and area like shown in lines 30-33

    while(fscanf(data_file, "%lf %lf", &radius, &nsides) == 2){
        perimeter = 2 * nsides * radius * sin(2 * M_PI / nsides);
        area = .5 * nsides * radius * radius * sin(2 * M_PI / nsides);
        fprintf(answer_file, "%8.3f %9.3f %14.3f %13.3f\n ", radius, nsides, perimeter, area);
    }

	fclose(data_file);
	fclose(answer_file);
	return EXIT_SUCCESS;
}
/*------------------------------------------------------------------*/
