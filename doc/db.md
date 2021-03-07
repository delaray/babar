# The Database

## Wikipedia Graph

The Wikipedia graph is maintained in a Postgresql database. A single table contains the vertices and the edges are distributed in 37 tables each represententing the first letter of the source verex name. While this makes outgoing edge retrieval reasonably efficient, it does make incoming edge retrieval relatively slow.

There are currently 4,603,307 vertices in the graph and a total of 96,260,661 edges in the graph. THe individual edge table counts are as follows:

| Table Name    |  Edge Count  |
|---------------|-------------:|
| wiki_edges_a  |      6531728 |
| wiki_edges_b  |      4765353 |
| wiki_edges_c  |      7413501 |
| wiki_edges_d  |      3334920 |
| wiki_edges_e  |      3680330 |
| wiki_edges_f  |      3276251 |
| wiki_edges_g  |      3583166 |
| wiki_edges_h  |      4057061 |
| wiki_edges_i  |      3295996 |
| wiki_edges_j  |      2329098 |
| wiki_edges_k  |      1816398 |
| wiki_edges_l  |      7514267 |
| wiki_edges_m  |      5990852 |
| wiki_edges_n  |      3384408 |
| wiki_edges_o  |      1829274 |
| wiki_edges_p  |      5946184 |
| wiki_edges_q  |       338560 |
| wiki_edges_r  |      3628513 |
| wiki_edges_s  |      8218867 |
| wiki_edges_t  |      5115081 |
| wiki_edges_u  |      1827505 |
| wiki_edges_v  |      1617824 |
| wiki_edges_w  |      2375294 |
| wiki_edges_x  |       149102 |
| wiki_edges_y  |       430624 |
| wiki_edges_z  |       665624 |
| wiki_edges_0  |         3364 |
| wiki_edges_1  |      1141692 |
| wiki_edges_2  |      1374292 |
| wiki_edges_3  |       145771 |
| wiki_edges_4  |       116729 |
| wiki_edges_5  |       139467 |
| wiki_edges_6  |        78025 |
| wiki_edges_7  |        63887 |
| wiki_edges_8  |        50295 |
| wiki_edges_9  |        31358 |
