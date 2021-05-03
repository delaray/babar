# BABAR Configuration

## Environment Variables

The following environment variables should be set to appropriate values:

BABAR_DIR
BABAR_DB_NAME  
BABAR_DB_PORT  
BABAR_DB_USER  
BABAR_DB_PWD

## Database Tables

BABAR assumes that the following tables exist:


### Non-Edge Tables

| name                         | type  | database |
| ---------------------------- | ----- | ---------|
| articles                     | table | postgres |
| dictionary                   | table | postgres |
| dictionary_attributes        | table | postgres |
| dictionary_unknown           | table | postgres |
| famous_birthdays             | table | postgres |
| famous_people                | table | postgres |
| famous_places                | table | postgres |
| famous_quotes                | table | postgres |
| mathematics_graph_edges      | table | postgres |
| mathematics_graph_topics     | table | postgres |
| ml_classifier_classes        | table | postgres |
| ml_classifiers               | table | postgres |
| ml_training_data             | table | postgres |
| ml_word_embedding_topics     | table | postgres |
| ml_word_embeddings           | table | postgres |
| root_subtopics               | table | postgres |
| root_topics                  | table | postgres |
| system_statistics            | table | postgres |
| topic_graphs                 | table | postgres |
| users                        | table | postgres |
| wiki_vertices                | table | postgres | 


### Edge and Reverse Edge Tables  

| name                         | type  | database |
| ---------------------------- | ----- | ---------|
| wiki_edges_0                 | table | postgres |
| wiki_edges_1                 | table | postgres |
| wiki_edges_2                 | table | postgres |
| wiki_edges_3                 | table | postgres |
| wiki_edges_4                 | table | postgres |
| wiki_edges_5                 | table | postgres |
| wiki_edges_6                 | table | postgres |
| wiki_edges_7                 | table | postgres |
| wiki_edges_8                 | table | postgres |
| wiki_edges_9                 | table | postgres |
| wiki_edges_a                 | table | postgres |
| wiki_edges_b                 | table | postgres |
| wiki_edges_c                 | table | postgres |
| wiki_edges_d                 | table | postgres |
| wiki_edges_e                 | table | postgres |
| wiki_edges_f                 | table | postgres |
| wiki_edges_g                 | table | postgres |
| wiki_edges_h                 | table | postgres |
| wiki_edges_i                 | table | postgres |
| wiki_edges_j                 | table | postgres |
| wiki_edges_k                 | table | postgres |
| wiki_edges_l                 | table | postgres |
| wiki_edges_m                 | table | postgres |
| wiki_edges_n                 | table | postgres |
| wiki_edges_o                 | table | postgres |
| wiki_edges_p                 | table | postgres |
| wiki_edges_q                 | table | postgres |
| wiki_edges_r                 | table | postgres |
| wiki_edges_s                 | table | postgres |
| wiki_edges_t                 | table | postgres |
| wiki_edges_u                 | table | postgres |
| wiki_edges_v                 | table | postgres |
| wiki_edges_w                 | table | postgres |
| wiki_edges_x                 | table | postgres |
| wiki_edges_y                 | table | postgres |
| wiki_edges_z                 | table | postgres |
| reverse_edges_0              | table | postgres |
| reverse_edges_1              | table | postgres |
| reverse_edges_2              | table | postgres |
| reverse_edges_3              | table | postgres |
| reverse_edges_4              | table | postgres |
| reverse_edges_5              | table | postgres |
| reverse_edges_6              | table | postgres |
| reverse_edges_7              | table | postgres |
| reverse_edges_8              | table | postgres |
| reverse_edges_9              | table | postgres |
| reverse_edges_a              | table | postgres |
| reverse_edges_b              | table | postgres |
| reverse_edges_c              | table | postgres |
| reverse_edges_d              | table | postgres |
| reverse_edges_e              | table | postgres |
| reverse_edges_f              | table | postgres |
| reverse_edges_g              | table | postgres |
| reverse_edges_h              | table | postgres |
| reverse_edges_i              | table | postgres |
| reverse_edges_j              | table | postgres |
| reverse_edges_k              | table | postgres |
| reverse_edges_l              | table | postgres |
| reverse_edges_m              | table | postgres |
| reverse_edges_n              | table | postgres |
| reverse_edges_o              | table | postgres |
| reverse_edges_p              | table | postgres |
| reverse_edges_q              | table | postgres |
| reverse_edges_r              | table | postgres |
| reverse_edges_s              | table | postgres |
| reverse_edges_t              | table | postgres |
| reverse_edges_u              | table | postgres |
| reverse_edges_v              | table | postgres |
| reverse_edges_w              | table | postgres |
| reverse_edges_x              | table | postgres |
| reverse_edges_y              | table | postgres |
| reverse_edges_z              | table | postgres |
