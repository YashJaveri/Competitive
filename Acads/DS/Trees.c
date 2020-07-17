#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *root = NULL;

void insert(struct node *tree, int val)
{
    struct node *newNode = NULL;
    newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = val;
    newNode->right = NULL;
    newNode->left = NULL;

    if (tree == NULL)
    {
        root = newNode;
        newNode->left = NULL;
        newNode->right = NULL;
    }
    else if (tree->data == val)
        printf("Data cannot be inserted!\n");
    else if (tree->left == NULL && val < tree->data)
        tree->left = newNode;
    else if (tree->right == NULL && val > tree->data)
        tree->right = newNode;
    else if (val < tree->data)
        insert(tree->left, val);
    else if (val > tree->data)
        insert(tree->right, val);
}

void pre(struct node *tree)
{
    if (tree != NULL)
    {
        printf("%d, ", tree->data);
        pre(tree->left);
        pre(tree->right);
    }
}

void post(struct node *tree)
{
    if (tree != NULL)
    {
        post(tree->left);
        post(tree->right);
        printf("%d, ", tree->data);
    }
}

void inord(struct node *tree)
{
    if (tree != NULL)
    {
        inord(tree->left);
        printf("%d, ", tree->data);
        inord(tree->right);
    }
}

struct node *findMinValue(struct node *tree)
{
    struct node *current = tree;

    while (current->left != NULL)
        current = current->left;
    return current;
}

struct node *delete (struct node *tree, int val)
{
    // base case
    if (tree == NULL)
    {
        printf("Tree is empty!");
        return tree;
    }
    else if (val < tree->data)
        tree->left = delete (tree->left, val);

    else if (val > tree->data)
        tree->right = delete (tree->right, val);
    // if val is same as tree's val, then This is the node to be deleted
    else
    {
        //node with no child
        if (tree->left == NULL && tree->right == NULL)
        {
            tree = NULL;
            return tree;
        }
        // node with only one child
        else if (tree->left == NULL)
        {
            struct node *temp = tree->right;
            free(tree);
            return temp;
        }
        else if (tree->right == NULL)
        {
            struct node *temp = tree->left;
            free(tree);
            return temp;
        }
        else if (tree->right != NULL && tree->left != NULL)
        {   // node with two children
            struct node *temp = findMinValue(tree->right);

            tree->data = temp->data;
            // Delete the inorder successor
            tree->right = delete (tree->right, temp->data);
        }
    }
    return tree;
}

int main()
{
    int a = 0, x = 0;
    int val = 0;

    do
    {
        printf("\nEnter\n1 to insert\n2 to delete\n3 to print\n0 to exit\n");
        scanf("%d", &a);

        switch (a)
        {
        case 0:
            printf("Exiting\n");
            break;
        case 1:
            printf("Enter the data which you want to insert:\n");
            scanf("%d", &val);
            insert(root, val);
            break;
        case 2:
            printf("Enter the number to be deleted: ");
            scanf("%d", &val);
            struct node *temp = delete (root, val);
            break;
        case 3:
            printf("Enter\n1 for preorder\n2 for postorder\n3 for inorder:\n");
            scanf("%d", &x);
            if (x == 1)
                pre(root);
            else if (x == 2)
                post(root);
            else if (x == 3)
                inord(root);
            break;
        default:
            break;
        }
    } while (a != 0);

    return 0;
}
