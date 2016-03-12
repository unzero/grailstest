
#include<iostream>
#include<fstream>
#include<sstream>
#include<cstdio>
#include<vector>
#include<list>
#include<stack>
#include<queue>
#include<deque>
#include<map>
#include<set>
#include<algorithm>
#include<cmath>
#include<string>
#include<cstring>
#include<cstdlib>
#include<climits>
#include<utility>
#include<cctype>
using namespace std;

#define ull unsigned long long
#define stt(it,order) sort(it.begin(),it.end(),order)
#define STT(it,n,order) sort(it,it+n,order)
#define st(it) sort(it.begin(),it.end())
#define ST(it,n) sort(it,it+n)
#define ll long long
#define rep(i,j) for(int i=0;i<j;++i)
#define loop(i,a,j) for(int i=a;i<j;++i)
#define mpi(it,table,T,E) for(map<T,E>::iterator it = table.begin();it!=table.end();++it)
#define PI 3.141592654
#define pb(v,e) v.push_back(e)
#define ms(a,v) memset(a,v,sizeof(a))
#define cp(a,b,n) rep(i,n)a[i] = b[i]
#define pi(a) printf("%d\n",a)
#define ps(a) printf("%s\n",a)
#define si(a) scanf("%d",&a)
#define print_int_matrix(mat,n) rep(i,n-1){printf("%d ",mat[i]);}printf("%d\n",mat[n-1]);
#define print_string_matrix(mat,n) rep(i,n-1){printf("%s ",mat[i]);}printf("%s\n",mat[n-1]);
#define mkp(a,b) make_pair(a,b)
#define fnd(table,e) (find(table.begin(),table.end(),e) != table.end())

//TYPOS DE DATOS PERSONALES
typedef unsigned int _set;
typedef unsigned long _lset;
typedef pair<int,int> pii;

string sint(int i){
   stringstream buf;
   buf<<i;
   return buf.str();
}

/*
ifstream fin("input.txt");
ofstream fout("output.txt");
#define cin fin
#define cout fout
*/

int dx[] = {-1,0,0,1};
int dy[] = {0,-1,1,0};
int dx8[] = {-1,-1,-1,0,0,1,1,1};
int dy8[] = {-1,0,1,-1,1,-1,0,1};


int main(){
   return 0;
}
