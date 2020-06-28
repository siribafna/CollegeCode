//
//  main.cpp
//  Homework_1
//
//  Created by Siri Bafna on 6/6/20.
//

#include <iostream>
#include <fstream>
#include <vector>
#include <cmath>
using namespace std;

//a.    a function to find the sum of a numeric vector
//b.    a function to find the mean of a numeric vector
//c.    a function to find the median of a numeric vector.
//d.    a function to find the range of a numeric vector
//e.    a function to compute covariance between rm and medv (see formula below)
//f.    a function to compute correlation between rm and medv (see formula below); Hint: sigma of a vector can be calculated as the square root of variance(v, v)


/*
 This program helps calculate different aspects such as the sum, mean, median, range, correlation and covariance from a dataset. 
 */

// function definitions
double sum(vector<double>);
double mean(vector<double>);
double median(vector<double>);
double range(vector<double>);
double cov(vector<double>, vector<double>);
double cor(vector<double>, vector<double>, double);
double stdDev(vector<double>);

int main() {

    ifstream file;
    string line;
    string rm_in, medv_in;
    const int MAX_LEN = 0;
    vector<double> rm(MAX_LEN);
    vector<double> medv(MAX_LEN);
    
    cout << "Opening file Homework1.csv" << endl;
    
    file.open("homework1.csv");
    if (!file.is_open()) { // troubleshooting for if the file can't open
        cout << "File could not open." << endl;
    }
    
    cout << "Reading line 1.." << endl;
    getline(file, line);
    cout << line << endl;

    while (file.good()) {
        getline(file, rm_in, ','); // stops at comma
        rm.push_back(stod(rm_in)); // converting the file to a double and then pushing in the vector
        getline(file, medv_in, '\n'); // stops at space
        medv.push_back(stod(medv_in));

    }
    
    cout << "rm length: " << rm.size() << endl; // shows length of the two vectors
    cout << "medv length: " << medv.size() << endl;
    cout << "Closing file." << endl; // close files
    
    // REPORTING RESULTS
    
    cout << "----------SUM----------" << endl;
    cout << "rm: " << sum(rm) << endl;
    cout << "medv: " << sum(medv) << endl;
    cout << "-----------------------" << endl;
    cout << endl;
    cout << "----------MEAN----------" << endl;
    cout << "rm: " << mean(rm) << endl;
    cout << "medv: " << mean(medv) << endl;
    cout << "-----------------------" << endl;
    cout << endl;
    cout << "----------MEDIAN----------" << endl;
    cout << "rm: " << median(rm) << endl;
    cout << "medv: " << median(medv) << endl;
    cout << "-----------------------" << endl;
    cout << endl;
    cout << "----------RANGE----------" << endl;
    cout << "rm: " << range(rm) << endl;
    cout << "medv: " << range(medv) << endl;
    cout << "-----------------------" << endl;
    cout << endl;
    cout << "----------COVARIANCE----------" << endl;
    cout << "covariance " << cov(rm, medv) << endl;
    cout << "-----------------------" << endl;
    cout << endl;
    cout << "----------CORRELATION----------" << endl;
    cout << "correlation " << cor(rm, medv, cov(rm, medv)) << endl;
    cout << "-----------------------" << endl;
}

double sum(vector<double> vector) {
    double sum = 0;
    for(int i = 0; i < vector.size(); i++) {
        sum += vector[i]; // adding all values of the vector into a variable
    }
    return sum;
}

double mean(vector<double> vector) {
    double mean = sum(vector) / vector.size(); // using sum function and simply dividing by vector size to get the mean
    return mean;
}

double median(vector<double> vector) {
    sort(vector.begin(), vector.end()); // sorts the vector from begin to end
    double median = 0;
    if (vector.size() % 2 != 0) { // if odd number
        double point = vector.size() / 2; // then stores the middle point
        point += .5; // adds .5 to turn into a whole number
        median = vector[point]; // find the median
    }
    else {
        if (vector.size() % 2 == 0) { // if even number
            double pointOne = vector.size() / 2; // find the first point
            double pointTwo = pointOne + 1; // find the point after that
            median = (vector[pointOne] + vector[pointTwo]) / 2; // find average of the two points
        }
    }
    return median;
}

double range(vector<double> vector) {
    sort(vector.begin(), vector.end());
    double range = vector[vector.size() - 1] - vector[0]; // last point - first point
    
    return range;
}

double cov(vector<double> rm, vector<double> medv) {
    double meanForRM = mean(rm); // stores the mean for both vectors
    double meanForMEDV = mean(medv);
    double sum = 0;
    for(int i = 0; i < rm.size(); i++) { //uses the formula to
        sum += (rm[i] - meanForRM) * (medv[i] - meanForMEDV); // get the point value and then subtract the mean for both vectors and then multplying them
    }
    
    return sum / (rm.size() - 1);
}

double cor(vector<double> rm, vector<double> medv, double covariance) {
    double stdDevRM = stdDev(rm); // uses the stddev function to for further calculations
    double stdDevMEDV = stdDev(medv);
    
    return covariance / (stdDevRM * stdDevMEDV); // follows the formula given
}

double stdDev(vector<double> vector) {
    double meanOfVect = mean(vector); // find the mean of the given vector
    double sum = 0;
    for(int i = 0; i < vector.size(); i++) {
        sum += pow(vector[i] - meanOfVect, 2); // squares the point - mean
    }
    double average = sum / vector.size(); // calculates the average as a variance
    
    return sqrt(average); // square roots the variance
}

